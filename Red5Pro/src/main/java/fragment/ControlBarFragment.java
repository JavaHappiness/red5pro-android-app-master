package fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.hunba.live.R;
import helpClass.AppState;


/**
 * 控制界面
 */
public class ControlBarFragment extends Fragment {
    private AppState currentState = null;
    private OnFragmentInteractionListener mListener;

    public ControlBarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_control_bar, container, false);

        ImageButton button = (ImageButton) v.findViewById(R.id.btnSettings);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onSettingsClick();
                }
            });
        }
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public boolean setSelection(AppState state) {
        if (currentState != null && currentState.equals(state)) {
            return false;
        }
        currentState = state;
        return true;
    }

    public void displayPublishControls(boolean show) {
        ImageButton cameraButton = (ImageButton) getActivity().findViewById(R.id.btnCamera);
        if (cameraButton != null) {
            cameraButton.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }

    public interface OnFragmentInteractionListener {
        void onSettingsClick();
    }

}
