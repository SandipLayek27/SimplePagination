package com.sandiplayek.paginationlibrary;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaginationFooterFragment extends Fragment implements View.OnClickListener{
    TextView tv_action;
    ImageView iv_prev_menu,iv_more_prev,iv_more_next,iv_next_menu;
    TextView tv_first_pos,tv_middle_pos,tv_last_pos;
    ImageView iv_go;
    EditText et_number;
    LinearLayout footer_pagination;
    int flag=0;
    OnButtonClickListener onButtonClickListener;
    LinearLayout ll_search_section;
    View view_line;
    String tPage="";
    int colorCode;

    public PaginationFooterFragment() {
        // Required empty public constructor
    }

    public void setOnFragmentBClickListener(OnButtonClickListener onButtonClickListener){
        this.onButtonClickListener = onButtonClickListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pagination_footer, container, false);
        footer_pagination=(LinearLayout)v.findViewById(R.id.footer_pagination);   //Total linear layout
        ll_search_section=(LinearLayout)v.findViewById(R.id.ll_search_section);   //Total linear layout
        tv_action=(TextView)v.findViewById(R.id.tv_action);           //After button click action text
        et_number=(EditText)v.findViewById(R.id.et_number);          //Searching by page number
        iv_prev_menu=(ImageView)v.findViewById(R.id.iv_prev_menu);    //Button for previous Listing
        iv_more_prev=(ImageView)v.findViewById(R.id.iv_more_prev);    //Denoted as previously have more Listing
        tv_first_pos=(TextView)v.findViewById(R.id.tv_first_pos);    //1st button action
        tv_middle_pos=(TextView)v.findViewById(R.id.tv_middle_pos);  //2nd button action
        tv_last_pos=(TextView)v.findViewById(R.id.tv_last_pos);      //3rd button action
        iv_more_next=(ImageView)v.findViewById(R.id.iv_more_next);    //Denoted as next has more Listing
        iv_next_menu=(ImageView)v.findViewById(R.id.iv_next_menu);    //Button for next Listing
        iv_go=(ImageView)v.findViewById(R.id.iv_go);                  //Search button action
        view_line=(View) v.findViewById(R.id.view_line);                  //Search button action

        iv_prev_menu.setOnClickListener(this);
        iv_next_menu.setOnClickListener(this);
        tv_first_pos.setOnClickListener(this);
        tv_middle_pos.setOnClickListener(this);
        tv_last_pos.setOnClickListener(this);
        iv_go.setOnClickListener(this);

        tPage=this.getArguments().getString("PAGE NUMBER").toString();
        colorCode=this.getArguments().getInt("PAGINATION COLOR");
        loadingView(tPage);
        footer_pagination.setBackgroundResource(colorCode);

        return v;
    }

    @Override
    public void onClick(View v) {
        if(v==tv_first_pos){
            fistPositionClickAction();
        }else if(v==tv_middle_pos){
            middlePositionClickAction();
        }else if(v==tv_last_pos){
            lastPositionClickAction();
        }else if(v==iv_next_menu){
            nextPositionClickAction();
        }else if(v==iv_prev_menu){
            prevPositionClickAction();
        }else if(v==iv_go){
            goPositionClickAction();
        }
    }

    public void loadingView(String totalPageNumber) {
        if(totalPageNumber.equals("1")){
            footer_pagination.setVisibility(View.GONE);
        }else if(totalPageNumber.equals("2")){
            iv_prev_menu.setVisibility(View.GONE);
            iv_next_menu.setVisibility(View.GONE);
            iv_more_prev.setVisibility(View.GONE);
            iv_more_next.setVisibility(View.GONE);
            tv_first_pos.setVisibility(View.VISIBLE);
            tv_middle_pos.setVisibility(View.VISIBLE);
            tv_last_pos.setVisibility(View.GONE);
            iv_go.setVisibility(View.GONE);
            et_number.setVisibility(View.GONE);
            ll_search_section.setVisibility(View.GONE);
            view_line.setVisibility(View.GONE);
        }else if(totalPageNumber.equals("3")){
            iv_prev_menu.setVisibility(View.GONE);
            iv_next_menu.setVisibility(View.GONE);
            iv_more_prev.setVisibility(View.GONE);
            iv_more_next.setVisibility(View.GONE);
            tv_first_pos.setVisibility(View.VISIBLE);
            tv_middle_pos.setVisibility(View.VISIBLE);
            tv_last_pos.setVisibility(View.VISIBLE);
            iv_go.setVisibility(View.GONE);
            et_number.setVisibility(View.GONE);
            ll_search_section.setVisibility(View.GONE);
            view_line.setVisibility(View.GONE);
        }else{
            ll_search_section.setVisibility(View.VISIBLE);
            footer_pagination.setVisibility(View.VISIBLE);
            iv_more_prev.setVisibility(View.GONE);
            tv_first_pos.setBackgroundResource(R.drawable.pagination_fill_color);
            view_line.setVisibility(View.VISIBLE);
        }
        /*if(onFooterFunctionalityListener!=null){
            onFooterFunctionalityListener.onLoadingResponse("Success");
        }*/
    }

    public void fistPositionClickAction() {
        String firstPositionValue=fetchTextValue(tv_first_pos);
        int fPosValue=Integer.parseInt(firstPositionValue);
        tv_action.setText(firstPositionValue);
        tv_first_pos.setBackgroundResource(R.drawable.pagination_fill_color);
        tv_middle_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
        tv_last_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
        onButtonClickListener.onFirstPositionClick(fPosValue);
    }

    public void middlePositionClickAction() {
        String middlePositionValue=fetchTextValue(tv_middle_pos);
        int mpos=Integer.parseInt(middlePositionValue);
        tv_action.setText(middlePositionValue);
        tv_first_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
        tv_middle_pos.setBackgroundResource(R.drawable.pagination_fill_color);
        tv_last_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
        onButtonClickListener.onMiddlePositionClick(mpos);
    }

    public void lastPositionClickAction() {
        String lastPositionValue=fetchTextValue(tv_last_pos);
        int lpos=Integer.parseInt(lastPositionValue);
        tv_action.setText(lastPositionValue);
        tv_first_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
        tv_middle_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
        tv_last_pos.setBackgroundResource(R.drawable.pagination_fill_color);
        onButtonClickListener.onLastPositionClick(lpos);
    }

    public void prevPositionClickAction() {
        String firstPositionValue=fetchTextValue(tv_first_pos);
        iv_more_next.setVisibility(View.VISIBLE);   //More next visibility view
        int printedValue = 0;
        if(firstPositionValue.equals("1")){
            //If 1st Position 1 then No action fired
            Toast.makeText(getActivity(), "First 3 positions already viewed", Toast.LENGTH_SHORT).show();
            return;
        }else if(firstPositionValue.equals("2")){
            //If 1st Position 2 then
            tv_first_pos.setText("1");      //Set 1st Position 1
            tv_middle_pos.setText("2");     //Set 2nd Position 2
            tv_last_pos.setText("3");       //Set 3rd Position 3

            tv_first_pos.setBackgroundResource(R.drawable.pagination_fill_color);           //Set 1st position background color selected
            tv_middle_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            tv_last_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);

            firstPositionValue=fetchTextValue(tv_first_pos);    //Fetch 1st Position value

            tv_action.setText(firstPositionValue);              //Action fired
            iv_more_prev.setVisibility(View.GONE);              //More prev visibility gone cause it sets initialize state
            printedValue=Integer.parseInt(firstPositionValue);

        }else if(firstPositionValue.equals("3")){
            //If 1st Position 3 then same task as 2
            tv_first_pos.setText("1");
            tv_middle_pos.setText("2");
            tv_last_pos.setText("3");
            tv_middle_pos.setBackgroundResource(R.drawable.pagination_fill_color);
            tv_first_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            tv_last_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            String middlePositionValue=fetchTextValue(tv_middle_pos);
            tv_action.setText(middlePositionValue);
            iv_more_prev.setVisibility(View.GONE);
            printedValue=Integer.parseInt(middlePositionValue);
        }else{
            int fpos=stringTointConverter(fetchTextValue(tv_first_pos));        //Get 1st position value as integer format
            int mpos=stringTointConverter(fetchTextValue(tv_middle_pos));       //Get 2nd position value as integer format
            int lpos=stringTointConverter(fetchTextValue(tv_last_pos));         //Get 3rd position value as integer format
            fpos-=1;                                //Decrement 1st position value -1
            mpos-=1;                                //Decrement 2nd position value -1
            lpos-=1;                                //Decrement 3rd position value -1
            setTextValue(tv_first_pos,""+fpos);     //Set value into the text field
            setTextValue(tv_middle_pos,""+mpos);    //Set value into the text field
            setTextValue(tv_last_pos,""+lpos);      //Set value into the text field
            tv_middle_pos.setBackgroundResource(R.drawable.pagination_fill_color);  //Set middle position background color fill others not fill
            tv_first_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            tv_last_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            setTextValue(tv_action,""+mpos);            //Set action text field value same as middle position value
            iv_more_prev.setVisibility(View.VISIBLE);   //more preview visibility visible
            printedValue=mpos;
        }
        onButtonClickListener.onPrevButtonClick(printedValue);
    }

    public void nextPositionClickAction() {
        int printedValue=0;
        int totalPage=stringTointConverter(tPage);               //Get the total page number as integer format
        if(stringTointConverter(fetchTextValue(tv_last_pos))==totalPage){   //Check last text position value same as total page number
            iv_more_next.setVisibility(View.GONE);                          //Then more next image view visibility gone
            Toast.makeText(getActivity(), "Total Page "+ tPage, Toast.LENGTH_SHORT).show();   //And print a text
            return;     //Return from this section
        }
        iv_more_prev.setVisibility(View.VISIBLE);       //Otherwise more preview and more next visibility Visible
        iv_more_next.setVisibility(View.VISIBLE);
        int fpos=stringTointConverter(fetchTextValue(tv_first_pos));    //Get 1st position value as integer format
        int mpos=stringTointConverter(fetchTextValue(tv_middle_pos));   //Get 2nd position value as integer format
        int lpos=stringTointConverter(fetchTextValue(tv_last_pos));     //Get 3rd position value as integer format
        fpos+=1;                                    //Increment 1st position value +1
        mpos+=1;                                    //Increment 2nd position value +1
        lpos+=1;                                    //Increment 3rd position value +1
        setTextValue(tv_first_pos,""+fpos);         //Set value into the text field
        setTextValue(tv_middle_pos,""+mpos);        //Set value into the text field
        setTextValue(tv_last_pos,""+lpos);          //Set value into the text field
        tv_middle_pos.setBackgroundResource(R.drawable.pagination_fill_color);          //Set middle position background color fill others not fill
        tv_first_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
        tv_last_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
        if(lpos==totalPage){                        //Again check last text position value same as total page number
            iv_more_next.setVisibility(View.GONE);  //if yes then mode next visibility gone
        }
        setTextValue(tv_action,""+mpos);            //Set action text field value same as middle position value
        printedValue=mpos;
        onButtonClickListener.onNextPositionClick(printedValue);
    }

    public void goPositionClickAction() {
        int printedValue=0;
        int searchingPageNumber=0;
        int totP=stringTointConverter(tPage);
        try{
            searchingPageNumber=stringTointConverter(et_number.getText().toString().trim());
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getActivity(), "Enter Valid Page Number", Toast.LENGTH_SHORT).show();
            return;
        }
        if(et_number.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Enter Page Number", Toast.LENGTH_SHORT).show();
            return;
        }
        if(searchingPageNumber<1){
            Toast.makeText(getActivity(), "Enter Valid Page Number", Toast.LENGTH_SHORT).show();
            return;
        }
        if(searchingPageNumber>totP){
            Toast.makeText(getActivity(), "Total Page "+ tPage, Toast.LENGTH_SHORT).show();
            return;
        }else if(searchingPageNumber==totP){
            int mPos=searchingPageNumber-1;
            int fPos=searchingPageNumber-2;
            int lPos=searchingPageNumber;
            setTextValue(tv_first_pos,""+fPos);
            setTextValue(tv_middle_pos,""+mPos);
            setTextValue(tv_last_pos,""+lPos);
            tv_first_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            tv_middle_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            tv_last_pos.setBackgroundResource(R.drawable.pagination_fill_color);
            iv_more_next.setVisibility(View.GONE);
            iv_more_prev.setVisibility(View.VISIBLE);
        }else if(searchingPageNumber<=0){
            Toast.makeText(getActivity(), "Enter valid searching number", Toast.LENGTH_SHORT).show();
            return;
        }else if(searchingPageNumber==1){
            setTextValue(tv_first_pos,"1");
            setTextValue(tv_middle_pos,"2");
            setTextValue(tv_last_pos,"3");
            tv_first_pos.setBackgroundResource(R.drawable.pagination_fill_color);
            tv_middle_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            tv_last_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            iv_more_prev.setVisibility(View.GONE);
            iv_more_next.setVisibility(View.VISIBLE);
        }else if(searchingPageNumber==2){
            setTextValue(tv_first_pos,"1");
            setTextValue(tv_middle_pos,"2");
            setTextValue(tv_last_pos,"3");
            tv_first_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            tv_middle_pos.setBackgroundResource(R.drawable.pagination_fill_color);
            tv_last_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            iv_more_prev.setVisibility(View.GONE);
        }else if(searchingPageNumber==3){
            setTextValue(tv_first_pos,"1");
            setTextValue(tv_middle_pos,"2");
            setTextValue(tv_last_pos,"3");
            tv_first_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            tv_middle_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            tv_last_pos.setBackgroundResource(R.drawable.pagination_fill_color);
            iv_more_prev.setVisibility(View.GONE);
        }else{
            int mPos=searchingPageNumber;
            int fPos=searchingPageNumber-1;
            int lPos=searchingPageNumber+1;
            setTextValue(tv_first_pos,""+fPos);
            setTextValue(tv_middle_pos,""+mPos);
            setTextValue(tv_last_pos,""+lPos);
            tv_first_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            tv_middle_pos.setBackgroundResource(R.drawable.pagination_fill_color);
            tv_last_pos.setBackgroundResource(R.drawable.edittext_shape_black_border);
            iv_more_prev.setVisibility(View.VISIBLE);
            iv_more_next.setVisibility(View.VISIBLE);
        }
        setTextValue(tv_action,""+searchingPageNumber);
        onButtonClickListener.onSearchingPositionClick(searchingPageNumber);
    }

    public String fetchTextValue(TextView tv){
        String value=tv.getText().toString().trim();
        return value;
    }

    public int stringTointConverter(String value){
        int convValue=Integer.parseInt(value);
        return convValue;
    }
    public void setTextValue(TextView tv,String value){
        tv.setText(value);
    }


    public interface OnButtonClickListener {
        void onFirstPositionClick(int position);
        void onMiddlePositionClick(int position);
        void onLastPositionClick(int position);
        void onPrevButtonClick(int position);
        void onNextPositionClick(int position);
        void onSearchingPositionClick(int position);
    }
}
