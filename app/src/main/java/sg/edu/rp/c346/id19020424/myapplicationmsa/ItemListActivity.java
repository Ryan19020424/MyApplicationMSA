package sg.edu.rp.c346.id19020424.myapplicationmsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {
    Button add,delete,update;
    EditText name, date, position;
    ListView lv;



    ArrayList<String> products;
    ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        add=findViewById(R.id.add);
        delete=findViewById(R.id.delete);
        update=findViewById(R.id.update);

        name=findViewById(R.id.name);
        date = findViewById(R.id.date);
        lv=findViewById(R.id.lv);

        products = new ArrayList<>();
        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,products);
        lv.setAdapter(aa);

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String newname = name.getText().toString();
                        String newdate = date.getText().toString();


                        if(newname!=null && newdate!=null) {

                            products.add(newname+" Expires " + newdate);
                            aa.notifyDataSetChanged();
                            Collections.sort(products);

                            name.setText(null);
                            date.setText(null);
                        }
                        else{
                            Toast.makeText(ItemListActivity.this, "Please enter all fields", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (products.size() == 0) {
                        Toast.makeText(ItemListActivity.this, "Nothing to Delete", Toast.LENGTH_LONG).show();
                    } else {
                                int pos1 = Integer.parseInt(position.getText().toString());
                                products.remove(pos1 - 1);
                                aa.notifyDataSetChanged();
                                position.setText(null);


                                Toast.makeText(ItemListActivity.this, "Please enter all fields", Toast.LENGTH_LONG).show();

                            }
                        }
                    });

                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (products.size() == 0) {
                                Toast.makeText(ItemListActivity.this, "Nothing to Update", Toast.LENGTH_LONG).show();
                            } else {
                                String updatename = name.getText().toString();
                                String updatedate = date.getText().toString();
                                String updateposition = position.getText().toString();

                                String upos = position.getText().toString();
                                int updatepos = Integer.parseInt(upos);

                                if (updatename != null && updatename != null && updatedate != null && updatepos != 0) {
                                    String newstring = (updatename + " Expires " + updatedate);
                                    products.set(updatepos - 1, newstring);
                                    aa.notifyDataSetChanged();

                                    name.setText(null);
                                    date.setText(null);
                                    position.setText(null);

                                } else {
                                    Toast.makeText(ItemListActivity.this, "Please enter all fields", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    }






