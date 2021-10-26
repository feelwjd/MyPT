package com.example.mypt;

public class Config { // URL 형식으로 통신함. 각 요소에 필요한 파라미터 값을 넘겨줘야 작동함. 파라미터 값 유무 잘 확인할 것.
    // 기능이 없어지고 통합되는 부분도 있을 수 있으니 그건 따로 전달해드리겠음.
    public static String BASE = "http://3.34.96.177:8000/"; //기본 우리 서버주소
    public static String USERS = BASE + "users/"; //이거 아무것도아닌데 나중에 추가되는 부분이 있을 수 있음.
    public static String SIGNUP = BASE + "users/signup"; // 회원가입 기능. 파라미터 값으론 userid, pw, username, height, weight, sex 있음 *sex는 0이 남자 / 1이 여자임.
    public static String SIGNIN = BASE + "users/signin"; // 로그인 기능. 파라미터 값으로 userid, pw가 필요.
    public static String SIGNOUT = BASE + "users/signout"; // 로그아웃 기능.
    public static String SIGNDEL = BASE + "users/signdel"; // 회원탈퇴 기능. 아직 개발중...
    public static String MAINPAGE = BASE + "main/"; // 아무것도 아닌데 나중에 추가되는 부분이 있을 수 있음.
    public static String CALENDAR = BASE + "main/calendar"; // 캘린더 기능. 아직 개발중...
    public static String TODO = BASE + "main/todolist"; // 투 두 리스트 기능. 아직 개발중...
    public static String FUNC = BASE + "func/"; //아무것도 아닌데 나중에 추가되는 부분이 있을 수 있음.
    public static String MKROUTINE = BASE + "func/mkroutine"; // 루틴 생성기인데 뒤의 produce_routine과 기능이 똑같아 통합예정임.
    public static String PICSHARE = BASE + "func/picshare"; // 이미지 공유 기능. 아직 개발중...
    public static String MYPAGE = BASE + "mypage/"; //아무것도 아닌데 나중에 추가되는 부분이 있을 수 있음.
    public static String BEFOREAFTER = BASE + "mypage/beforeafter"; // 비포 애프터 기능.
    public static String PRODUCEROUTINE = BASE + "mypage/produce_routine"; // 루틴 생성기 기능. 파라미터 값으로 routinename, description, userid, workoutid 값이 필요함.
                                                                            // *workoutid 값은 리스트형태로 [1,2,3,11] 이런형태로 가능함.
    public static String SETROUTINE = BASE + "mypage/set_routine"; // 루틴 설정 기능. 아직 개발중...
    public static String COMMU = BASE + "commu/"; //아무것도 아닌데 나중에 추가되는 부분이 있을 수 있음.
    public static String SHARE = BASE + "commu/share"; // 커뮤니티 공유 기능. 아직 개발중...
    public static String ILIKEYOU = BASE + "commu/i_like_you"; // 커뮤니티 좋아요 기능. 아직 개발중...
    public static String APIUSER = BASE + "api/user"; // 사용자 정보 확인 기능. 파라미터 값으로 userid 필요.
    public static String APIROUTINE = BASE + "api/routine"; // 모든사람 루틴 확인 기능. 아마 쓸일 없을껀데 혹시 몰라서 넣어봄.
    public static String APIWORKOUT = BASE + "api/workout"; // 전체 운동 데이터 확인 기능.
    public static String APIUSER_ROUTINE = BASE + "api/user-routine"; // 사용자의 루틴 데이터 확인 기능. 파라미터 값으로 userid 필요.
    public static String APIROUTINE_WORKOUT = BASE + "api/routine-workout"; // 루틴별 운동 목록 확인 기능. 보완예정임...
    public static String APIUSER_ROUTINE_WORKOUT = BASE + "api/user-routine-workout"; // 사용자별 루틴 정보 및 루틴내의 운동목록 확인 기능. 파라미터 값으로 userid 필요.
    public static String APIWORKOUT_CLASS = BASE + "api/workout-class"; // 기구 필요 유무 운동 확인 기능. 파라미터 값으로 workout_class 필요. 0은 기구 필요X / 1은 기구 필요O
    public static String APIROUTINEINFO = BASE + "api/routine-info"; // 루틴의 전반적인 정보를 나타냄. 파라미터 값으로 userid 필요.
    public static String SHAREIMAGE = BASE + "shareimage/image"; // 사진을 넣으면 루틴정보가 담긴 사진으로 반환해줌. 파라미터 값으로 UserRoutineId 값이 필요. UserRoutineId는 APIROUTINEINFO에서 확인 가능함.
}
