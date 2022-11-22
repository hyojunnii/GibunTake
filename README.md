# <img src="https://user-images.githubusercontent.com/96437859/203319416-bc8b7035-73be-492c-9286-974a1ba70bcf.png" width="4%" height="4%"> 기부앤테이크 Gibu n Take
> 기부 중개 웹 사이트


## 1. 제작 기간 & 참여인원
- 2022.07.01 ~ 2022.08.26
- 팀프로젝트, 6명
- [팀 깃허브](https://github.com/hyojunnii/GibuAndTake) <br>


## 2. 사용 기술
#### `Back-end`
  - JAVA 11
  - Servlet
  - JSP
  - Oracle DB (XE 21c)
#### `Front-end`
  - HTML5
  - CSS3
  - JavaScript
  - jQuery 3.6.0
#### `Server`
  - Apache Tomcat 9.0
#### `tools / Libraries`
  - Eclipse 4.23.0
  - Visual Studio Code 1.70.2
  - SqlDeveloper 21.4.3
  - SourceTree 3.4.8
  - ERD Cloud
  - Figma
  - BootStrap5


## 3. 프로젝트 소개
기부/펀딩/캠페인 프로젝트를 조회하고 참여할 수 있는 중개 사이트입니다. <br>
다양한 규모의 기부단체들이 제공된 양식에 맞춰 활동을 신청하고 관리할 수 있으며, <br>
일반인들을 대상으로 모금활동, 펀딩(투자), 캠페인등 기부 활동에 대한 접근성을 높이고자 기획하였습니다. <br>
네이버 해피빈, 카카오 같이가치를 참고하였습니다.

<details>
<summary><b>전체 기능 펼치기</b></summary>
<div markdown="1">

### 4.1. 팀원별 기능
  
- **김우인(조장)** - 로그인, 회원가입, ID찾기, PWD찾기, 회원정보수정
- **권효정(형상관리)** - 프로젝트 신청, 수정, 캠페인 인증, 통합검색, 메인페이지, 더미데이터
- **조아연(DB관리)** - 명세서/영수증 조회, 출력, 홈페이지소개
- **곽우진** - 결제, 후기, 스토리(프로젝트현황), 헤더푸터
- **박준혁** - 프로젝트 조회, 프로젝트 참여, 댓글
- **박찬수** - 공지사항, FAQ/문의게시판, 일정관리

### 4.2. 기능 상세

- **일반회원/기업**
  - 회원가입/탈퇴
  - 로그인/로그아웃
  - 아이디/비밀번호찾기
  - 기부명세서 관리
  - 기부영수증 관리

- **프로젝트**
  - 프로젝트 신청
  - 프로젝트 수정
  - 프로젝트 조회
  - 결제
  - 캠페인 인증
  - 후기
  - 댓글
  
- **게시판**
  - 공지사항
  - FAQ
  - 문의
  
- **홈페이지**
  - 통합검색
  - 스토리 (프로젝트 현황)
  - 소개페이지
  - 메인페이지
  
</div>
</details>


## 4. ERD 설계
[ERD Cloud](https://www.erdcloud.com/d/MD3avQAnxDDqXMq2D)를 사용하여 공동 작업
<details>
<summary><b>전체 테이블 보기</b></summary>

![기부앤테이크](https://user-images.githubusercontent.com/96437859/203082016-5668bb7c-fda4-4d78-8d52-49ce1a049a4f.png)

</details>


## 5. 담당 기능 

- #### 프로젝트 신청 / 신청내역조회 / 수정
  - 작성 템플릿을 제공하여 프로젝트를 신청받거나 수정받는 페이지
  - 신청한 프로잭트 내역과 승인/반려여부를 확인할 수 있는 페이지
  - summernote 에디터를 활용한 콘텐츠 작성
  - 페이징 처리
- #### 캠페인 인증
  - 인증사진과 간단한 소감을 올려 캠페인에 참여하는 기능
  - File Upload 기능 구현
  - JavaScript를 사용한 글자수 제한
- #### 통합검색
  - 추천목록, 키워드검색, 카테고리별검색이 가능한 통합검색 페이지
  - 모든 검색에 대한 최신순/인기순 정렬 기능
  - 페이징 처리
- #### 메인페이지, 더미데이터 제작
  - BootStrap5를 사용한 화면구현
  - 일일 통계, 추천목록 제공
  - 해피빈, 카카오같이가치 사이트를 참고한 더미데이터 제작
- #### 공통
  - Servlet 기반 CRUD
  - MVC 패턴 사용
  - JSP, EL, jstl을 사용한 화면구현

- Notion으로 화면 미리보기 : <https://hyojunnii.notion.site/d45614820fcc40f5b93d4d63c10d628c/>
  
## 6. 기능 리뷰
<details>
<summary>프로젝트 신청</summary>
- 기부/펀딩/캠페인이 등록테이블을 중심으로 각각 세부사항이 여러개로 나뉘어 있었으며, 최대 4개의 테이블에 데이터를 나누어 넣어줬어야 했다.<br>
- if문으로 돌아가면서 데이터를 삽입했고, 중간에 삽입이 안될시 전체 롤백되는 코드로 작성하였다.
</details>
<details>
<summary>프로젝트 신청 컨텐츠 작성</summary>
- 기존 textarea를 사용하다 화면이 아쉽다는 생각이 들었고, 팀원분이 summernote 에디터를 추천해주어 사용하게 되었다. <br>
- 사용방법을 익히는데 시간이 다소 소요되었다.
</details>
<details>
<summary>프로젝트 신청/수정시 세부사항 증감</summary>
- 기부/펀딩에서 세부지출사항목록과 리워드목록을 입력받아야 했고 추가하거나 삭제한 칸을 모두 DB에 적용해야 했다. <br>
- 칸 추가/삭제는 JavaScript 테이블 셀추가로 구현하였으며 string 배열로 각각 저장하여 반복문으로 삽입하였다. <br>
- 프로젝트 수정도 목록을 DB에서 배열로 받아와 jstl 반복문으로 화면에 출력하였다.
</details>
<details>
<summary>프로젝트신청/캠페인인증 파일업로드</summary>
- form의 multipartdata방식으로 받아와 currenttimemills와 randomUUID를 사용하여 새로운 이름을 생성하고 <br>
  stream을 사용하여 바뀐 파일 명으로 서버에 저장하고 DB에 이름을 업로드해주었다.
</details>
<details>
<summary>통합검색 페이지</summary>
- 추천목록/키워드검색/주제별검색 별로 화면을 다르게 나타내기 위해 EL표현식을 사용하였다. <br>
- PageVo를 만들고 SQL ROWNUM과 서브쿼리를 사용하여 페이징 처리를 구현하였다. <br>
- 기능별로 DAO단에서 정렬을 따로 구현하였다..
</details>


## 7. 회고
> Spring Framework를 사용하기 전 바탕이 되는 Servlet으로 웹사이트를 구현하였는데 기능 하나하나를 구현하는데 시간이 많이 소요되었고, 코드의 길이가 길어 수정이 까다로운 점이 있었다. <br>
> 사진 파일을 수정하는 기능을 넣고 싶었는데, 파일 업로드를 완벽하게 숙지하지 못했고 특히 화면구현이 어려워 시간내에 구현하지 못해 아쉬웠다. <br>
> 통합검색 페이지에서 정렬기능을 구현하는게 큰 과제였는데, 수많은 오류와 수정을 거치며 결국 작동이 되어 뿌듯했지만, 코드가 너무 길다.<br>

> 프로젝트 전체적으로는 비슷하고 시간이 많이 소요되는 기능들로 기획한 것이 아쉬웠던 것 같다. <br>
> 특히 기부/펀딩/캠페인으로 나눠지는 화면과 기능이 계속 반복되었으며, 한가지에만 집중하고 조금 더 다양한 기능을 구현했었으면 좋았을 것 같다.


## 8. 링크 모음
- [Notion 프로젝트 포트폴리오](https://hyojunnii.notion.site/d45614820fcc40f5b93d4d63c10d628c) <br>
- [팀 깃허브](https://github.com/hyojunnii/GibunTake) <br>
- [ERD Cloud](https://www.erdcloud.com/d/MD3avQAnxDDqXMq2D) <br>
- [팀 노션](https://www.notion.so/KH-4-46c42e462fe74c1abfe1acb507359903) <br>
- [팀 피그마](https://www.figma.com/file/BjvrCMClye5Cgx58PvTPwF/%ED%99%94%EB%A9%B4%EC%84%A4%EA%B3%84?t=dFgdYHRAEsNBZb71-0)
