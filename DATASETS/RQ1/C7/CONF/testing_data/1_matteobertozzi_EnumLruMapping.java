public class EnumLruMapping {
  private static final int MIN_ENUM_STRING_LENGTH = 3;
  private static final int MAX_INDEX_LENGTH = 0xffff;

  private final int lruSize;
  private final int minFreq;

  private ItemNode[] buckets;
  private ItemNode[] indexed;
  private ItemNode lruHead;
  private int indexedCount;
  private int lruUsed;

  public EnumLruMapping(final int lruSize, final int minFreq) {
    this.lruSize = lruSize;
    this.minFreq = minFreq;

    this.indexed = new ItemNode[64];
    this.buckets = new ItemNode[tableSizeForItems(lruSize)];
    this.lruHead = new ItemNode();
  }

  public String get(final int index) {
    return indexed[index].key;
  }

  public int add(final String key) {
    if (key.length() < MIN_ENUM_STRING_LENGTH) return -1;

    final int hash = hash(key);
    final int bucketIndex = hash & (buckets.length - 1);

    final ItemNode root = buckets[bucketIndex];
    final ItemNode item = findNode(root, key, hash);
    if (item == null) {
      if (indexedCount == MAX_INDEX_LENGTH) return -1;
      buckets[bucketIndex] = addNode(key, hash, root);
      return -1;
    }

    
    if (item.index >= 0) {
      item.freq++;
      return item.index;
    }

    if (indexedCount == MAX_INDEX_LENGTH) return -1;
    return incFreq(item);
  }

  private ItemNode findNode(ItemNode node, final String key, final int keyHash) {
    while (node != null && !node.match(key, keyHash)) {
      node = node.hashNext;
    }
    return node;
  }

  private ItemNode addNode(final String key, final int keyHash, ItemNode hashNext) {
    ItemNode node;
    if (lruUsed == lruSize) {
      if ((node = lruHead.lruPrev) == hashNext) {
        hashNext = hashNext.hashNext;
      }
      removeKey(node);
    } else {
      node = lruHead.isEmpty() ? lruHead : new ItemNode();
      lruUsed++;
    }
    
    node.hashNext = hashNext;
    node.set(key, keyHash);
    moveToLruFront(node);
    return node;
  }

  private int incFreq(final ItemNode item) {
    if (++item.freq < minFreq) {
      moveToLruFront(item);
      return -1;
    }

    if (indexedCount == indexed.length) {
      this.indexed = Arrays.copyOf(indexed, indexedCount << 1);
      resizeTable();
    }

    if (item == lruHead) {
      if (item == item.lruNext) {
        lruHead = new ItemNode();
      } else {
        moveToLruFront(item.lruNext);
      }
    }

    
    item.unlink();
    indexed[indexedCount] = item;
    item.setIndex(indexedCount++);
    lruUsed--;
    return -1;
  }

  private void removeKey(final ItemNode node) {
    final int bucketIndex = node.hash & (buckets.length - 1);
    node.set(null, -1);

    ItemNode hashNode = buckets[bucketIndex];
    if (hashNode == node) {
      buckets[bucketIndex] = hashNode.hashNext;
      return;
    }

    while (hashNode.hashNext != node) {
      hashNode = hashNode.hashNext;
    }
    hashNode.hashNext = node.hashNext;
  }

  private void moveToLruFront(final ItemNode node) {
    if (node == lruHead) return;

    node.unlink();

    final ItemNode tail = lruHead.lruPrev;
    node.lruNext = lruHead;
    node.lruPrev = tail;
    tail.lruNext = node;
    lruHead.lruPrev = node;
    lruHead = node;
  }

  private void resizeTable() {
    final int newSize = tableSizeForItems(lruSize + indexedCount);
    if (newSize == buckets.length) return;

    final int mask = newSize - 1;
    final ItemNode[] newBuckets = new ItemNode[newSize];

    
    for (int i = 0; i < indexedCount; ++i) {
      final ItemNode node = indexed[i];
      final int index = node.hash & mask;
      node.hashNext = newBuckets[index];
      newBuckets[index] = node;
    }

    
    ItemNode node = lruHead;
    do {
      final int index = node.hash & mask;
      node.hashNext = newBuckets[index];
      newBuckets[index] = node;

      node = node.lruNext;
    } while (node != lruHead);

    this.buckets = newBuckets;
  }

  private static int tableSizeForItems(final int expectedItems) {
    return 1 << (Integer.SIZE - Integer.numberOfLeadingZeros((expectedItems * 2) - 1));
  }

  private static int hash(final String key) {
    final int h = key.hashCode();
    return (h ^ (h >>> 16)) & 0x7fffffff;
  }

  private static final class ItemNode {
    private ItemNode hashNext;
    private ItemNode lruNext;
    private ItemNode lruPrev;
    private String key;
    private int hash;
    private int index;
    private int freq;

    private ItemNode() {
      this.lruNext = this;
      this.lruPrev = this;
    }

    void set(final String key, final int hash) {
      this.key = key;
      this.hash = hash;
      this.freq = 1;
      this.index = -1;
    }

    void setIndex(final int index) {
      this.index = index;
      this.lruNext = null;
      this.lruPrev = null;
    }

    boolean isEmpty() {
      return key == null;
    }

    boolean match(final String otherKey, final int otherHash) {
      return this.hash == otherHash && this.key.equals(otherKey);
    }

    void unlink() {
      lruPrev.lruNext = lruNext;
      lruNext.lruPrev = lruPrev;
    }
  }
}
