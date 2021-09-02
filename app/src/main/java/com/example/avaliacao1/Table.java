package com.example.avaliacao1;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Table {
    private boolean isReserved;
    private LinearLayout layout;
    private Button btn;

    public Table(LinearLayout layout, Button btn, boolean isReserved) {
        this.layout = layout;
        this.btn = btn;
        setReserved(isReserved);

        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setReserved(true);
            }
        });
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;

        btn.setClickable(!isReserved);
        layout.setBackgroundColor(layout.getResources().getColor(isReserved ? R.color.reserved_table : R.color.free_table));
    }
}