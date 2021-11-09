# ❄ Database 기초 팀 프로젝트 - 직원검색시스템

- 조건에 맞는 직원들을 검색, 추가, 삭제, 수정 할 수 있는 웹 애플리케이션을 구현한다

## 📢 프로젝트 목표

### 1. 직원 검색
- EMPLOYEE 테이블의 모든 Attribute 출력
- Super_ssn과 Dno 대신 상사의 이름과 부서명으로 바꿔서 출력

### 2. 직원 검색 필터
- 검색 범위 선택 가능 (전체, 부서, 성별, 연봉, 생일, 부하직원)
- 검색 항목 필터 적용 가능 (Attribute 선택 가능)

### 3. 검색된 직원 선택 후 DB에서 삭제
- 검색된 직원을 선택 가능해야 함
- 여러 명 동시에 선택 및 삭제 가능해야 함

### 4. 검색된 직원 선택 후 정보 수정
- 검색된 직원을 선택 가능해야 함
- 수정할 항목 선택 가능 (Address, Sex, Salary)

### 5. 새로운 직원의 정보를 GUI에서 직접 추가
- 직원 정보 추가 GUI 필요
- 추가 불가시(ex. Ssn 중복 등) 예외 처리


## ⚙ 서비스 아키텍쳐

![image](https://user-images.githubusercontent.com/65909160/140850329-5a73fea3-fa37-4e3a-b4ed-8f04f1972e50.png)

## 🎞 실행 화면

### 1. 직원 검색
![image](https://user-images.githubusercontent.com/65909160/140923938-9d70f46c-5b6a-45ff-b7f4-1b9845d2bbcb.png)


### 2. 직원 검색 필터

- Research 부서만 검색 시

![image](https://user-images.githubusercontent.com/65909160/140924680-8537d809-952f-424e-9070-e67ea4b13d08.png)


### 3. 검색된 직원 선택 후 DB에서 삭제

- 직원 선택 후 delete 버튼을 눌러 삭제 가능

![image](https://user-images.githubusercontent.com/65909160/140924786-781a2929-2ba4-410a-a84d-a468b1e075d1.png)


### 4. 검색된 직원 선택 후 정보 수정

- 직원 선택 후 정보 수정 가능
- 이때 정보 수정이 제대로 이루어지지 않았다면 예외 페이지 View

![image](https://user-images.githubusercontent.com/65909160/140924941-035eda80-6d34-437e-8ee2-a9bd0d4006bd.png)


### 5. 새로운 직원의 정보를 GUI에서 직접 추가

- 새로운 직원 정보 GUI에서 직접 추가 가능
- 잘못된 입력으로 인하여 직원 정보 추가 불가능 시 예외 페이지 View

![image](https://user-images.githubusercontent.com/65909160/140924986-7afe6f17-524c-4241-a117-4a53ca5fa091.png)


## 🛠 기술 스택

- ### **프론트엔드**

  <img alt="JSP" src="https://img.shields.io/badge/JSP-007396.svg?style=for-the-badge&logo=Java&logoColor=%2361DAFB"/>

- ### **백엔드**

    <img alt="Spring" src="https://img.shields.io/badge/Spring-6DB33F.svg?style=for-the-badge&logo=Spring&logoColor=white"/>
    <img alt="MySQL" src="https://img.shields.io/badge/MySQL-4479A1.svg?style=for-the-badge&logo=MySQL&logoColor=white"/>
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-6DB33F.svg?style=for-the-badge&logo=SpringBoot&logoColor=white"/>
    <img alt="JDBC" src="https://img.shields.io/badge/JDBC-007396.svg?style=for-the-badge&logo=Java&logoColor=%2361DAFB"/>

- ### **형상 관리**

    <img alt="Git" src="https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white"/>

    <img alt="GitHub" src="https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white"/>
