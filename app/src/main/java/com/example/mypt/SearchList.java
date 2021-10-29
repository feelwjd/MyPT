package com.example.mypt;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchList extends AppCompatActivity {

    private List<String> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<String>();

        settingList();

        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list, this);
        listView.setAdapter(adapter);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editSearch.getText().toString();
                search(text);
            }
        });


    }

    // 검색을 수행하는 메소드
    public void search(String charText) {
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        else
        {
            for(int i = 0;i < arraylist.size(); i++)
            {
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되니까 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){
        list.add("싸이클");
        list.add("엘립티컬 머신");
        list.add("러닝");
        list.add("트레드밀 러닝");
        list.add("버피");
        list.add("점핑잭");
        list.add("줄넘기");

        list.add("런지");
        list.add("스모 덤벨 스쿼트");
        list.add("카프레이즈");
        list.add("이너 싸이 머신");
        list.add("원 레그 니업");
        list.add("와이드 스쿼트");
        list.add("스모 데드리프트");

        list.add("크런치");
        list.add("브이업");
        list.add("크로스 바디 크런치");
        list.add("니 투 엘보");
        list.add("리버스 플랭크");
        list.add("러시안 트위스트");
        list.add("사이드 밴드");

        list.add("데드리프트");
        list.add("바벨 로우");
        list.add("풀 업");
        list.add("루마니안 데드리프트");
        list.add("렛 풀다운");
        list.add("백 익스텐션");
        list.add("원 암 덤벨 로우");

        list.add("벤치 프레스");
        list.add("풀오버");
        list.add("팩덱 플라이");
        list.add("푸쉬업");
        list.add("케이블 크로스오버");
        list.add("딥스");
        list.add("체스트 프레스");

        list.add("오버헤드 프레스");
        list.add("숄더 프레스");
        list.add("레터럴 레이즈");
        list.add("시티드 오버헤드 프레스");
        list.add("프론트 레이즈");
        list.add("페이스 풀");
        list.add("리버스 플라이");

        list.add("트라이셉 익스텐션");
        list.add("킥백");
        list.add("원 암 트라이셉 익스텐션");
        list.add("벤치 딥스");
        list.add("클로즈 그립 벤치프레스");
        list.add("라잉 트라이셉 익스텐션");
        list.add("트라이셉스 딥스 플로어");

        list.add("바이셉 컬");
        list.add("친 업");
        list.add("프리쳐 컬");
        list.add("바이셉 컬");
        list.add("해머 컬");
        list.add("컨셉트레이션 퀄");
        list.add("프리쳐 컬");

        list.add("리스트 컬(덤벨)");
        list.add("리스트 컬(바벨)");
        list.add("리스트 롤러");
        list.add("리버스 리스트 컬(바벨)");
        list.add("리버스 리스트 컬(덤밸)");


    }

}