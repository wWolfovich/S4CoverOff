package org.durka.hallmonitor;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.ImageView;

public class CallDragListener implements OnDragListener {
	
    @Override
    public boolean onDrag(View v, DragEvent event) {
      int action = event.getAction();
      switch (event.getAction()) {
      case DragEvent.ACTION_DRAG_STARTED:
    	  Log.d("DragnDrop", "Event received");
        break;
      case DragEvent.ACTION_DRAG_ENTERED:
    	  Log.d("DragnDrop", "Icon now is in target area");        
    	  break;
      case DragEvent.ACTION_DRAG_EXITED:
    	  Log.d("DragnDrop", "Icon now is out of the target area");
        break;
      case DragEvent.ACTION_DROP: {
    	  if (event.getClipDescription().getLabel().equals("Pickup")) {
    		  Functions.Actions.pickup_call();
    		  Log.d("DragnDrop", "PickUp Call");
    	  } if (event.getClipDescription().getLabel().equals("Hang")) {
    		  Functions.Actions.hangup_call();
    		  Log.d("DragnDrop", "Hangup Call");
    	  }
      }
    	  Log.d("DragnDrop", "Icon dropped in target area");
        break;
      case DragEvent.ACTION_DRAG_ENDED:
    	  if (dropEventNotHandled(event)) {
              v.setVisibility(View.VISIBLE);
              Log.d("DragnDrop", "Not dropped in target area, restoring default");
          }
      default:
        break;
      }
      return true;
    }

    private boolean dropEventNotHandled(DragEvent event) {
        return !event.getResult();
    }

}