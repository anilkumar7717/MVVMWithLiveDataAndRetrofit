package com.example.test.mvvmsampleapp.view.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.test.mvvmsampleapp.R;
import com.example.test.mvvmsampleapp.service.model.Project;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add project list fragment if this is first creation
        if (savedInstanceState == null) {
            ProjectListFragment fragment = new ProjectListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, ProjectListFragment.TAG).commit();
        }
    }

    /**
     * Shows the project detail fragment
     */
    public void show(Project project) {
        ProjectFragment projectFragment = ProjectFragment.forProject(project.name);

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("project")
                .replace(R.id.fragment_container,
                        projectFragment, null).commit();
    }
}
