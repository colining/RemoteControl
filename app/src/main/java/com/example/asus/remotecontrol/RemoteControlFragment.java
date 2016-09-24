package com.example.asus.remotecontrol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by asus on 2016/9/24.
 */
public class RemoteControlFragment extends Fragment{
    private TextView selectedTextView;
    private TextView WorkingTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle s) {
     View v = inflater.inflate(R.layout.fragment_remote_control, parent, false);
        selectedTextView = (TextView) v.findViewById(R.id.control_selectedTextView);
        WorkingTextView = (TextView) v.findViewById(R.id.control_workingTextView);

        View.OnClickListener numberButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) view;
                String working = WorkingTextView.getText().toString();
                String text = textView.getText().toString();
                Log.d("lalalalal",text);
                if (working.equals("0")) {
                    WorkingTextView.setText(text);
                } else {
                    WorkingTextView.setText(working + text);
                }


            }
        };
//        Button zerobutton = (Button)v.findViewById(R.id.control_zerobutton);
//        zerobutton.setOnClickListener(numberButtonListener);
//
//        Button onebutton = (Button)v.findViewById(R.id.control_onebutton);
//        onebutton.setOnClickListener(numberButtonListener);
        TableLayout tableLayout = (TableLayout)v.findViewById(R.id.fragmen_remote_control_tableLayout);
        int number =1 ;
        for(int i =2;i<tableLayout.getChildCount()-1;i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                Button button = (Button) row.getChildAt(j);
               button.setText("" + number);
                button.setOnClickListener(numberButtonListener);
                number++;
            }
        }
            TableRow bottomrow = (TableRow)tableLayout.getChildAt(tableLayout.getChildCount()-1);
            Button deletebutton = (Button)bottomrow.getChildAt(0);
            deletebutton .setText("Delete");
            deletebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    WorkingTextView.setText("0");
                }
            });
            Button zerobutton = (Button)bottomrow.getChildAt(1);
            zerobutton.setText("0");
            zerobutton.setOnClickListener(numberButtonListener);


        Button enterbutton = (Button)bottomrow.getChildAt(2);
        enterbutton.setText("Enter");

        enterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence working = WorkingTextView.getText();
                if(working.length()>0)
                {
                    selectedTextView.setText(working);
                    WorkingTextView.setText("0");
                }
            }
        });
        return  v;
    }
}
