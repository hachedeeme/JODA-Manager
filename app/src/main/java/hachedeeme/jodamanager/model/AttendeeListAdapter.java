package hachedeeme.jodamanager.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tpi1 on 11/03/15.
 */
public class AttendeeListAdapter extends BaseExpandableListAdapter{

    private Context context;
    private List<MeetingAttendee> attendees;

    public AttendeeListAdapter(Context aContext){
        this.context = aContext;
        this.attendees = new ArrayList<MeetingAttendee>();
        this.initialize();
    }

    public void initialize(){
        Consumable salad    = new Consumable("Ensalada");
        Consumable barbecue = new Consumable("Asado");
        Consumable wine     = new Consumable("Vinito");
        Consumable grenadine= new Consumable("Granadina");
        Consumable cheese   = new Consumable("Provoleta ");
        // and some attendees who pay
        MeetingAttendee hache = new MeetingAttendee("Hache");
        hache.pay(20D, salad);
        hache.pay(100D, barbecue);
        hache.pay(30D, wine);

        this.attendees.add(hache);

        MeetingAttendee sol = new MeetingAttendee("Sol");
        sol.pay(10D, salad);
        sol.pay(0D, barbecue);
        sol.pay(30D, cheese);
        sol.pay(30D, grenadine);
        this.attendees.add(sol);

        MeetingAttendee leo = new MeetingAttendee("Leonora");
        leo.pay(0D, salad);
        leo.pay(0D, cheese);
        leo.pay(0D, grenadine);
        this.attendees.add(leo);

        MeetingAttendee jona = new MeetingAttendee("Jona");
        jona.pay(0D, barbecue);
        jona.pay(0D, salad);
        jona.pay(0D, wine);
        this.attendees.add(jona);
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LinearLayout view = new LinearLayout(this.context);
        view.setOrientation(LinearLayout.HORIZONTAL);


        TextView attendeeView = new TextView(this.context);
        String attendeeName = this.attendees.get(groupPosition).getName();
        attendeeView.setText(attendeeName);
        attendeeView.setPadding(80, 10, 10, 10);
        attendeeView.setTextSize(20);

        view.addView(attendeeView);
        //view.addView(new EditText(this.context));
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView consumableView = new TextView(this.context);
        String consumableName = this.attendees.get(groupPosition).getPayments().get(childPosition).getConsumable().getName();
        consumableView.setText(consumableName);
        consumableView.setPadding(50, 10, 10, 10);
        consumableView.setTextSize(20);
        return consumableView;
    }

    @Override
    public int getGroupCount() {
        return this.attendees.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.attendees.get(groupPosition).getPayments().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
