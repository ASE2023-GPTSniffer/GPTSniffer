public class SimpleActivity {
  private static final int PICK_IMAGE_ID = 234; 
  
  public void onPickImage(View view) {
    Intent chooseImageIntent = ImagePicker.getPickImageIntent(this);
    startActivityForResult(chooseImageIntent, PICK_IMAGE_ID);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch(requestCode) {
        case PICK_IMAGE_ID:
            Bitmap bitmap = ImagePicker.getImageFromResult(this, resultCode, data);
            
            break;
        default:
            super.onActivityResult(requestCode, resultCode, data);
            break;
    }
  }
}
