package org.mp.a1022mvvmpracticedatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.database.DatabaseUtils;
import android.os.Bundle;

import org.mp.a1022mvvmpracticedatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final CustomViewModel customViewModel = ViewModelProviders.of(this).get(CustomViewModel.class);

        customViewModel.getUserModelMutableLiveData().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {

                ActivityMainBinding binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

                // The Data Binding Library generates a class named BR
                // which contains the IDs of the resources used for data binding
                // here 'data' is the id of the resource
                // in the xml file
                binding.setVariable(BR.data, userModel);
                binding.executePendingBindings();

                //So no need to do this:
                // binding.setData(customViewModel);
                // binding.email.setText(userModel.getEmail());
                // binding.password.setText(userModel.getPassword());
                //binding.executePendingBindings();

            }
        });

    }
}
