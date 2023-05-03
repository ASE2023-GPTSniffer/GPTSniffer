





public class CheatSheet {
    
    private static final int ESTIMATED_TOAST_HEIGHT_DIPS = 48;

    
    public static void setup(View view) {
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return showCheatSheet(view, view.getContentDescription());
            }
        });
    }

    
    public static void setup(View view, final int textResId) {
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return showCheatSheet(view, view.getContext().getString(textResId));
            }
        });
    }

    
    public static void setup(View view, final CharSequence text) {
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return showCheatSheet(view, text);
            }
        });
    }

    
    public static void remove(final View view) {
        view.setOnLongClickListener(null);
    }

    
    private static boolean showCheatSheet(View view, CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            return false;
        }

        final int[] screenPos = new int[2]; 
        final Rect displayFrame = new Rect(); 
        view.getLocationOnScreen(screenPos);
        view.getWindowVisibleDisplayFrame(displayFrame);

        final Context context = view.getContext();
        final int viewWidth = view.getWidth();
        final int viewHeight = view.getHeight();
        final int viewCenterX = screenPos[0] + viewWidth / 2;
        final int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        final int estimatedToastHeight = (int) (ESTIMATED_TOAST_HEIGHT_DIPS
                * context.getResources().getDisplayMetrics().density);

        Toast cheatSheet = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        boolean showBelow = screenPos[1] < estimatedToastHeight;
        if (showBelow) {
            
            
            cheatSheet.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL,
                    viewCenterX - screenWidth / 2,
                    screenPos[1] - displayFrame.top + viewHeight);
        } else {
            
            
            
            
            cheatSheet.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL,
                    viewCenterX - screenWidth / 2,
                    screenPos[1] - displayFrame.top - estimatedToastHeight);
        }

        cheatSheet.show();
        return true;
    }
}
