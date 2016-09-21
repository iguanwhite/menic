package com.menic.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import com.kioja.menic.R;

public class ItemAdapter extends BaseAdapter{ 
private Activity activity;
private ArrayList<HashMap<String, String>> data;
private static LayoutInflater inflater=null;
public ImageSwitcher imageLoader; 

public ItemAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
    activity = a;
    data=d;
    inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    imageLoader=new ImageSwitcher(activity.getApplicationContext());
}

public int getCount() {
    return data.size();
}

public Object getItem(int position) {
    return position;
}

public long getItemId(int position) {
    return position;
}

public View getView(int position, View convertView, ViewGroup parent) {
    View v=convertView;
    if(convertView==null)
        v = inflater.inflate(R.layout.rowlayoutlistaopcoes, null);


	TextView nome = (TextView) v.findViewById(R.id.nomeOpcao);
	EditText qtd = (EditText) v.findViewById(R.id.fieldQuantidadeOpcoes);
	
    
    HashMap<String, String> hashProduto = new HashMap<String, String>();
    hashProduto = data.get(position);
    
    // Setting all values in listview
    nome.setText(hashProduto.get("nome"));
    qtd.setText(hashProduto.get("preco"));
    
    //imageLoader.DisplayImage(song.get(CustomizedListView.KEY_THUMB_URL), thumb_image);
    return v;
}

}
