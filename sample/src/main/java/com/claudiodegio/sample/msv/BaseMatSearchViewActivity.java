package com.claudiodegio.sample.msv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.claudiodegio.msv.BaseMaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public abstract class BaseMatSearchViewActivity extends AppCompatActivity {

    Toolbar mToolbar;
    @BindView(R.id.rv_item)
    RecyclerView mRvItem;

    @BindView(R.id.sv)
    BaseMaterialSearchView mSearchView;

    @BindView(R.id.cl)
    CoordinatorLayout mCoordinator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mToolbar = findViewById(R.id.toolbar);
        // Action bar di supporti
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getTitle());

        ButterKnife.bind(this);

        init();

        initCustom();
    }

    public int getLayoutId() {
        return R.layout.test_msv_simple;
    }

    protected void init(){
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        mRvItem.setLayoutManager(layoutManager);
        mRvItem.setHasFixedSize(true);

        List<String> list = new ArrayList<>();

        list.add("Have");
        list.add("Sodium");
        list.add("Routine");
        list.add("Systematic");
        list.add("Departure");
        list.add("Transparent");
        list.add("Amputate");
        list.add("Dialogue");
        list.add("Uncle");
        list.add("Credit card");
        list.add("Greet");
        list.add("Dollar");

        mRvItem.setAdapter(new MatSearchViewActivity.SimpleRVAdapter(list));
    }

    protected void initCustom(){

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.test_adv_serach_view, menu);
        mSearchView.setMenuItem(menu.findItem(R.id.action_search));
        return true;
    }
    public class SimpleRVAdapter extends RecyclerView.Adapter<SimpleRVAdapter.SimpleViewHolder> {
        private List<String> dataSource;

        SimpleRVAdapter(List<String> dataArgs) {
            dataSource = dataArgs;
        }

        @NonNull
        @Override
        public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // create a new view
            View view = LayoutInflater.from(BaseMatSearchViewActivity.this).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new SimpleViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
            holder.textView.setText(dataSource.get(position));
        }

        class SimpleViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            SimpleViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView;
            }
        }

        @Override
        public int getItemCount() {
            return dataSource.size();
        }
    }
}
