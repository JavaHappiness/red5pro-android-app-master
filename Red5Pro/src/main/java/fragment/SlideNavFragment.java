package fragment;

import activity.PublishActivity;
import activity.ServerSettingActivity;
import activity.SubscribeActivity;
import activity.TwoWayActivity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.hunba.live.R;

/**
 * Created by davidHeimann on 8/5/16.
 * 侧边栏
 */
public class SlideNavFragment extends Fragment {

    public RelativeLayout navView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        navView = (RelativeLayout)inflater.inflate(R.layout.fragment_slide_nav, null, false);

        //server
        navView.findViewById(R.id.serverBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), ServerSettingActivity.class));
                getActivity().finish();
            }
        });

        //publish
        navView.findViewById(R.id.publishBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), PublishActivity.class));
                getActivity().finish();
            }
        });

        //subscribe
        navView.findViewById(R.id.subscribeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), SubscribeActivity.class));
                getActivity().finish();
            }
        });

        //two way
        navView.findViewById(R.id.twowayBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), TwoWayActivity.class));
                getActivity().finish();
            }
        });

        //help
        navView.findViewById(R.id.helpBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpDialogFragment helpDialog = HelpDialogFragment.newInstance();
                helpDialog.show(getFragmentManager().beginTransaction(), "help_dialog");
            }
        });

        return navView;
    }
}
