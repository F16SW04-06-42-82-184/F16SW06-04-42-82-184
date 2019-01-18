package com.candybreaker.user.bluetoothlab;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    BluetoothAdapter mBluetoothAdapter;
    ListView list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        //list = (ListView)findViewById(R.id.list);
        if(mBluetoothAdapter == null){
            Toast.makeText(this, "Bluetooth Adapter found", Toast.LENGTH_SHORT).show();
        }
    }

    public void TurnOn(View v){
        if(!mBluetoothAdapter.isEnabled()){
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth, 0);
            Toast.makeText(this, "Bluetooth Enabled", Toast.LENGTH_SHORT).show();
        }
    }

    public  void GetVisible(View v){
        Intent visible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        visible.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(visible);
        Toast.makeText(this, "Device is Visible", Toast.LENGTH_SHORT).show();
    }

    public void showPairedDevice(View v ){

        Set<BluetoothDevice> pairDevices = mBluetoothAdapter.getBondedDevices();
        List<String> s= new ArrayList<String>();
        if(pairDevices.size() > 0){
            for(BluetoothDevice device : pairDevices){
                s.add(device.getName());
            }

            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, s);
            list = (ListView)findViewById(R.id.list);
            list.setAdapter(adapter);


    }
    }

    public void TurnOff (View v){
        if(mBluetoothAdapter.isEnabled()){
            mBluetoothAdapter.disable();
        }

    }

}
