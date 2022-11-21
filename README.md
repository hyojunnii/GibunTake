# :pushpin: 기부앤테이크 GibunTake
> 기부 중개 웹 사이트
> 

<br>

## 1. 제작 기간 & 참여인원
- 2022/07/01 ~ 2022/08/25 (55일)
- 팀프로젝트, 6명

<br>

## 2. 사용 기술
#### `Back-end`
  - JAVA 11
  - Servlet
  - JSP
  - Oracle DB (21c xe)
#### `Front-end`
  - HTML5
  - CSS3
  - JavaScript
  - jQuery
  - AJAX
#### `tools`
  - Eclipse
  - Visual Studio Code
  - SqlDeveloper
  - SourceTree
  - ERD Cloud
  - Figma

</br>

## 3. 프로젝트 소개
기부/펀딩/캠페인 프로젝트를 조회하고 참여할 수 있는 중개 사이트입니다. <br>
다양한 규모의 기부단체들이 제공된 양식에 맞춰 활동을 신청하고 관리할 수 있으며, <br>
일반인들을 대상으로 모금활동, 펀딩(투자), 캠페인등 기부 활동에 대한 접근성을 높이고자 기획하였습니다. <br>
네이버 해피빈, 카카오 같이가치를 참고하였습니다.

<details>
<summary><b>전체 기능 펼치기</b></summary>
<div markdown="1">

### 4.1. 팀 기능
  
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

<br>

## 4. ERD 설계
![](https://zuminternet.github.io/images/portal/post/2019-04-22-ZUM-Pilot-integer/final_erd.png)


## 5. 담당 기능

- #### 프로젝트 신청
  - 
- #### 프로젝트 수정
  - 
- #### 캠페인 인증
  - 
- #### 통합검색
  - 
- #### 메인페이지, 더미데이터 제작
  -

<br>
  
## 6. 코드 리뷰

### 6.1. Controller


### 6.2. Service


### 6.3. Repository

</br>

## 7. 트러블 슈팅
### 7.1. 컨텐츠 필터와 페이징 처리 문제
- 저는 이 서비스가 페이스북이나 인스타그램 처럼 가볍게, 자주 사용되길 바라는 마음으로 개발했습니다.  
때문에 페이징 처리도 무한 스크롤을 적용했습니다.

- 하지만 [무한스크롤, 페이징 혹은 “더보기” 버튼? 어떤 걸 써야할까](https://cyberx.tistory.com/82) 라는 글을 읽고 무한 스크롤의 단점들을 알게 되었고,  
다양한 기준(카테고리, 사용자, 등록일, 인기도)의 게시물 필터 기능을 넣어서 이를 보완하고자 했습니다.

- 그런데 게시물이 필터링 된 상태에서 무한 스크롤이 동작하면,  
필터링 된 게시물들만 DB에 요청해야 하기 때문에 아래의 **기존 코드** 처럼 각 필터별로 다른 Query를 날려야 했습니다.

<details>
<summary><b>기존 코드</b></summary>
<div markdown="1">

~~~java
  
~~~

</div>
</details>



<details>
<summary><b>개선된 코드</b></summary>
<div markdown="1">

~~~java
  
~~~

</div>
</details>

</br>

## 8. 그 외 트러블 슈팅
<details>
<summary>npm run dev 실행 오류</summary>
<div markdown="1">

- Webpack-dev-server 버전을 3.0.0으로 다운그레이드로 해결
- `$ npm install —save-dev webpack-dev-server@3.0.0`

</div>
</details>
    
</br>

## 9. 회고 / 느낀점
> 
