# <div align=center><img src="https://user-images.githubusercontent.com/87016481/147246971-455576a5-638a-4489-bf35-675f0c12de0b.png" width="256" height="160"></div><br>LDIT by 평범한 직원들
> LDIT은 LET'S DO IT TOGETHER의 약자로 프로젝트 중심의 그룹웨어입니다. 시장의 불확실성이 증가하면서 기업들 또한 시대에 발맞추어 조직 구조를 개편하는 노력을 하고 있습니다. 조직 구조를 바꾸어 변화에 성공한 기업들이 도입한 에자일 방법론은 고객과 최접점에 있는 직원들에게 권한을 나누어주고 워크플로우를 외부 변화에 최적화하여 구성하는 것을 말합니다. 성공적으로 조직 구조를 적용한다는 것은, 실제로 일하는 직원들의 작업 방식이 변하는 것을 필수적으로 포함합니다. 우리 '평범한 직원들'은 기업의 구성원들이 새로운 조직문화에 쉽게 적응하여 효과를 낼 수 있도록 직관적인 인터페이스와 권한 위임을 통한 효율적인 프로젝트 관리를 담아낸 그룹웨어를 선보입니다.
## 목차
[1. 개발환경](#개발환경)   
[2. 프로젝트 설계주안점](#프로젝트-설계주안점)   
[3. 구현 기능](#구현-기능)   
[4. 팀원 및 주 담당 기능](#팀원-및-주-담당-기능)   
[5. ERD](#erd)   
[6. 프로젝트 화면](#프로젝트-화면)

## 개발환경
+ **Language**
  + JAVA 8
  + HTML5
  + CSS3
  + JavaScript
  + JSP
  + SQL
+ **Database**
  + Oracle 11g 
+ **Web Server & WAS**
  + Apache-Tomcat 8.5.70
+ **Framework & Library**
  + Spring Framework(STS 3)
  + MyBatis 3.4.5
  + jQuery 3.6.0
  + Gson
  + FullCalendar 5.10.1
  + JSTL Core
  + EL
  + Ajax
+ **Tools & ETC**
  + GitHub
  + Oracle SQL Developer
  + Maven 3.8.3
  + TortoiseGit
## 프로젝트 설계주안점
+ 프로젝트 관리, 개인 일정관리, 출퇴근 및 휴가 관리, 1대1 메시지 전송 기능 포함
+ Empowerment 개념을 적용한 프로젝트 관리(직급과 분리된 PM/TM 권한 관리, PM과 TM의 권한 내용 차별화)
+ 직관적인 인터페이스로 워크플로우 쉽게 확인 가능
+ 정보의 지속성을 위해 삭제 기능 제거 및 비활성화 기능 추가

## 구현 기능
+ **로그인 관련** : 로그인/로그아웃 기능, 아이디 저장 기능, login 인터셉터 기능, 로그인 계정 별 권한에 따른 페이지 접근 제한 기능
+ **메인페이지 구성** : '오늘의 일정' 연동, 소속된 '프로젝트' 연동, 쪽지 즐겨찾기함 기능, 출근 기능, 기본 근태정보 확인 기능, 쪽지 수신 알람 기능
+ **조직도 및 직원 관리** : 조직도(부서별 정렬), 직원정보 수정 기능, 직원정보 삭제 기능
+ **근무계획 설정** : 저장된 근무제도 불러오기 기능, 근무제도 설정 및 변경 기능(근무제, 근무요일, 근무시간, 휴식제도), 휴가코드 관리 기능(설정, 삭제)
+ **개인 근태관리** : 출근/퇴근 기능, 휴식시작/휴식 종료 기능, 휴가/재택근무 신청 기능, 휴가상세내역 조회 기능(최신순, 예정일정순), 재택근무 상세내역 조회 기능(최신순, 예정일정순), 근무내역 상세내역 조회 기능(최신순), 근무제에 따른 총 근무시간 계산 기능
+ **개인 스케쥴 관리** : 일정 등록 기능, 일정 수정 기능, 일정 삭제 기능, 일정 월간/주간/일간 출력 기능
+ **1:1 쪽지** : 쪽지 송신 기능, 쪽지 수신 기능, 송신한 쪽지 리스트 조회 기능, 수신한 쪽지 리스트 조회 기능, 쪽지 상세보기 기능, 쪽지 삭제 기능
+ **PM 권한 등록** : 사원 검색 기능(조건 : 부서/이름/사원번호), 사원 PM 등록 기능
+ **프로젝트 관리** : 프로젝트 페이지 접근 제한 기능, 프로젝트 생성 기능(TM 등록 기능 포함), 프로젝트 진행도 수정 및 표시 기능, 프로젝트 상세보기 기능, 프로젝트 리스트 출력 기능
+ **고객요구사항 관리** : 고객요구사항 페이지 접근 제한 기능, 고객요구사항 등록 기능, 우선순위 변경 기능, 고객요구사항 비활성화 기능, 고객요구사항 상세보기 기능, 고객 요구사항 리스트 출력
+ **팀 관리** : 팀 페이지 접근 제한 기능, 팀 개설 기능, 팀 정보수정 기능, 팀원 초대 기능, 직원 검색 기능, 팀 목표 등록 기능, 팀 목표 수정 기능, 팀 목표 비활성화 기능

## 팀원 및 주 담당 기능
> **김예은**
>> Header/Sidebar UI   
>> 메인 페이지 구성   
>> 고객요구사항 관리   
>> 팀 관리   
>> 개인 스케쥴 관리

> **김정기**
>> PM 권한 등록   
>> 프로젝트 관리

> **한설빈**
>> 메인 페이지 구성 기능 일부(출근 기능, 쪽지 즐겨찾기함 기능)   
>> 근무계획 설정   
>> 개인 근태관리

> **백건호**
>> 1:1 쪽지   
>> 조직도 및 직원 관리

> **양제훈**
>> 로그인 관련 기능   
>> DB 관리
## ERD
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147334914-e95b2916-15a5-4e60-ae09-2fe23595c9b0.png" width="100%"></div>

## 프로젝트 화면

### [로그인 화면]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853461-0172fcd3-72cc-416b-a832-f7cc7092c593.png" width="100%"></div>

### [메인 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853472-83c3ada8-9399-41da-b9c5-7f1861e84b5a.png" width="100%"></div>   
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853474-9f5b1aa5-c8e2-49af-932b-07d3fc0e33cb.png" width="100%"></div>

### [개인 스케쥴 관리 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853501-fd86f820-b8e5-4ad3-8565-c5691c2492df.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853504-09e52158-3faa-4baf-b355-595d59cae3ed.png" width="100%"></div>

### [출퇴근 관리 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853512-ea1c3ca7-3bd7-4499-9228-d24dcdea7be7.png" width="100%"></div>

### [근무계획 설정 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853514-0612de1a-d8d4-4747-88d5-7c666bb7682b.png" width="100%"></div>

### [권한관리 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853517-15ce0ada-ac9e-4e37-b2ba-8043a8072702.png" width="100%"></div>

### [프로젝트 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853525-8e91f388-0f83-4671-be25-41a7a6403ac2.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853526-2da85d83-ce2d-4ec9-b03d-84f872c61e7c.png" width="100%"></div>

### [고객요구사항 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853559-51ddd5e5-1879-495a-890d-e6b1bba8486b.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853563-6524ff43-5d8b-4c98-b335-0ac58e905ee7.png" width="100%"></div>

### [팀 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853578-90c78440-d49a-4762-a649-e4f4ff38f515.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853581-0fd31bd7-8715-4062-a202-d1f41caef400.png" width="100%"></div>

### [팀 목표 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853586-231843f7-9dd9-45a9-8986-74b1b56db800.png" width="100%"></div>

### [조직도 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853602-42c1fdef-190c-40aa-b765-08be3e1afce8.png" width="100%"></div>

### [직원정보 수정 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853618-d2db8bb6-d269-4fd6-a09c-b5380a2bb18d.png" width="100%"></div>

### [쪽지 보내기 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853630-bea861a2-35db-40f2-8153-1e9309261155.png" width="100%"></div>

### [보낸 쪽지함 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853641-b0b33461-59eb-4f7e-9d80-fd080e34ffc0.png" width="100%"></div>

### [받은 쪽지함 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147853634-efc8254d-6f68-4a6e-a1c3-09df45cc35cf.png" width="100%"></div>
