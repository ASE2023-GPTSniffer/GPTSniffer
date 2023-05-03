public class MyStringBuilder2 {
    private char[] value;
    private int count;

    public MyStringBuilder2() {
        value = new char[16];
    }

    public MyStringBuilder2(char[] chars) {
        value = chars;
        count = chars.length;
    }

    public MyStringBuilder2(String s) {
        value = s.toCharArray();
        count = s.length();
    }

    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
        if (offset < 0 || offset > count) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        int len = s.length();
        ensureCapacity(count + len);
        System.arraycopy(value, offset, value, offset + len, count - offset);
        System.arraycopy(s.value, 0, value, offset, len);
        count += len;
        return this;
    }

    public MyStringBuilder2 reverse() {
        for (int i = 0, j = count - 1; i < j; i++, j--) {
            char temp = value[i];
            value[i] = value[j];
            value[j] = temp;
        }
        return this;
    }

    public MyStringBuilder2 substring(int begin) {
        return substring(begin, count);
    }

    public MyStringBuilder2 substring(int begin, int end) {
        if (begin < 0 || begin > end || end > count) {
            throw new StringIndexOutOfBoundsException();
        }
        int len = end - begin;
        char[] newvalue = new char[len];
        System.arraycopy(value, begin, newvalue, 0, len);
        return new MyStringBuilder2(newvalue);
    }

    public MyStringBuilder2 toUpperCase() {
        for (int i = 0; i < count; i++) {
            value[i] = Character.toUpperCase(value[i]);
        }
        return this;
    }

    private void ensureCapacity(int minimumCapacity) {
        if (minimumCapacity > value.length) {
            expandCapacity(minimumCapacity);
        }
    }

    private void expandCapacity(int minimumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity < minimumCapacity) {
            newCapacity = minimumCapacity;
        }
        char[] newValue = new char[newCapacity];
        System.arraycopy(value, 0, newValue, 0, count);
        value = newValue;
    }

    public int length() {
        return count;
    }

    public char charAt(int index) {
        if (index < 0 || index >= count) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }

    public String toString() {
        return new String(value, 0, count);
    }
}
