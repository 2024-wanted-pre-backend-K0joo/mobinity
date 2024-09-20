# Mobinity

### ✨ Backend TechStack
![Java](https://img.shields.io/badge/-Java-FF7800?style=flat&logo=Java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-flat&logo=spring&logoColor=white)
![SpringBoot](https://img.shields.io/badge/-SpringBoot-6DB33F?style=flat&logo=SpringBoot&logoColor=white)
![SpringDataJPA](https://img.shields.io/badge/SpringDataJpa-236DB33F?style=flat&logo=spring&logoColor=white)
![SpringSecurity](https://img.shields.io/badge/Spring%20Security-6DB33F?style=flat&logo=Spring%20Security&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white)

</br>

### 🍀 서비스 개요 🍀
본 서비스는 로그인 및 사용자 유형에 따라 다른 상품 목록을 제공합니다. </br>
다양한 할인된 가격을 한 번에 리스트로 확인할 수 있습니다.
</div>

</br>

## [목차]
- [📁 디렉토리 구조](#디렉토리-구조)
- [📦 ERD](#erd)
- [💌 API 명세서](#api-명세서)
- [✉ Git Commit Message Convention](#-git-commit-message-convention)
- [🌿 Git Branch 전략](#-git-branch-전략)

## 디렉토리 구조
<details>
<summary><strong>구조도</strong></summary>
<div markdown="1">
  
```
─src
    ├─main
    │  ├─java
    │  │  └─wanted
    │  │      └─mobinity
    │  │          │  MobinityApplication.java
    │  │          │  
    │  │          ├─domain
    │  │          │  ├─brand
    │  │          │  │  ├─entity
    │  │          │  │  └─repository
    │  │          │  │          
    │  │          │  ├─grade
    │  │          │  │  ├─entity
    │  │          │  │  └─repository
    │  │          │  │          
    │  │          │  ├─product
    │  │          │  │  ├─controller
    │  │          │  │  ├─dto
    │  │          │  │  ├─entity
    │  │          │  │  ├─repository
    │  │          │  │  └─service
    │  │          │  │          
    │  │          │  └─user
    │  │          │      ├─controller
    │  │          │      ├─dto
    │  │          │      ├─entity
    │  │          │      ├─repository  
    │  │          │      └─service
    │  │          │              
    │  │          └─global
    │  │              ├─config
    │  │              ├─error
    │  │              │  └─exception
    │  │              └─response
    │  │                      
    │  └─resources
    │      │  application.properties
    │      │  data.sql
    │      │  
    │      ├─static
    │      └─templates
    └─test
        └─java
            └─wanted
                └─mobinity
                        MobinityApplicationTests.java

```

</details>

## ERD
<img width="718" alt="모비니티 erd" src="https://github.com/user-attachments/assets/6c603561-354e-447b-879a-a6d8413598f8" width="90%" height="100%">

</br>

## API 명세서
### 🙋‍♀️ 사용자 회원 가입
#### 1. 설명
- `계정명`, `패스워드`를 입력하여 회원가입 합니다.
</br>

#### 2. 입력
- url
> `POST` http://localhost:8080/users/signup

- body
```
{
  "account": "계정명",
  "password": "비밀번호",
  "name" : "이름"
}
```

#### 3. 출력
- **Response : 성공 시**
```
{
    "status": 200,
    "code": "U003",
    "message": "회원가입에 성공하였습니다.",
    "data": {
        "userId": "유저 UUID",
        "account": "계정명",
        "password": "암호화된 비밀번호",
        "name": "이름",
        "createdAt": "생성된 시간",
        "grade": {
            "gradeId": 1,
            "name": "Beginner",
            "discountRate": 5
        }
    }
}
```

</br>

- **Response : 실패 시**
- 이미 존재하는 ID 일 때
```
{
    "status": 400,
    "code": "U002",
    "message": "이미 존재하는 사용자 계정입니다."
}
```

- ID 또는 Password 입력하지 않을 시
```
{
    "status": 400,
    "code": "G001",
    "message": "내부 서버 오류입니다."
}
```

</br>

### 🔍 사용자 로그인
#### 1. 설명
- 사용자 로그인 기능입니다.

    - 사용자가 로그인할 수 있는 기능을 구현합니다.
    - 아이디/비번이 다를 때 다른 예외처리를 해야 합니다.

#### 2. 입력
- url
> `POST` http://localhost:8080/users/signin

- body
```
{
  "account": "계정명",
  "password": "비밀번호"
}
```

#### 3. 출력
- **Response : 성공 시**
```
{
    "status": 200,
    "code": "U001",
    "message": "로그인에 성공하였습니다.",
    "data": {
        "account": "계정명",
        "name": "이름"
    }
}
```

- **Response : 실패시**
- 존재하지 않는 ID로 로그인 시
```
{
    "status": 400,
    "code": "U001",
    "message": "존재하지 않는 유저입니다."
}
```

- ID와 Password가 일치하지 않을 때
```
{
    "status": 401,
    "code": "U006",
    "message": "비밀번호가 계정과 일치하지 않습니다."
}
```

### 🔍 상품 목록 불러오기
- 현재 데이터 넣어서 테스트 중인데 데이터 입력이 이상하게 되어서 수정중입니다.

</br>

## ✉ Git Commit Message Convention
<details>
<summary>커밋 유형</summary>
<div markdown="1">
</br>
  <table>
    <tr>
      <th scope="col">커밋 유형</td>
      <th scope="col">의미</td>
    </tr>
    <tr>
      <td>feat</td>
      <td>새로운 기능 추가</td>
    </tr>
    <tr>
      <td>fix</td>
      <td>버그 수정</td>
    </tr>
    <tr>
      <td>docs</td>
      <td>문서 수정</td>
    </tr>
    <tr>
      <td>style</td>
      <td>코드 formatting, 세미콜론 누락, 코드 자체의 변경이 없는 경우</td>
    </tr>
    <tr>
      <td>refactor</td>
      <td>코드 리팩토링</td>
    </tr>
    <tr>
      <td>test</td>
      <td>테스트 코드, 리팩토링 테스트 코드 추가</td>
    </tr>
    <tr>
      <td>chore</td>
      <td>패키지 매니저 수정, 그 외 기타 수정 ex) .gitignore</td>
    </tr>
  </table>
  </br>
</div>
</details>

<details>
<summary>커밋 메세지 세부 내용</summary>
<div markdown="1">
</br>
&emsp;• 글로 작성하여 내용이 잘 전달될 수 있도록 할 것 </br></br>
&emsp;• 본문에는 변경한 내용과 이유 설명 (어떻게보다는 무엇 & 왜를 설명)</br>
&emsp;<div align="center" style="width:90%; height: 140px; border: 1px solid gray; border-radius: 1em; background-color: #AEADAB; color: black; text-align: left ">
&emsp;ex ) </br>
&emsp;refactor : 로그인 기능 변경 (title)</br>
&emsp;( 공 백 ) </br>
&emsp;기존 로그인 방식에서 ~~한 문제로 ~~한 방식으로 변경하였습니다. (content)
</br>
</br>
&emsp;feat : 로그인 기능 구현
</div>
</div>
</details>

## 🌿 Git Branch 전략
<details>
<summary>브렌치 명명 규칙</summary>
<div markdown="1">
</br>

`feat/기능명`

- ex)  feat/users_apply

</div>
</details>

<details>
<summary>브랜치 작성 방법</summary>
<div markdown="1">
</br>

- 브랜치는 기능 단위로 나눈다.
- feat 브랜치는 dev 브랜치에서 파생해서 만든다.
- PR을 통해 dev 브랜치에서 기능이 완성되면 main 브랜치로 merge 한다.

</br>

|이름|텍스트|
|----|-----|
|main|제품으로 출시될 수 있는 브랜치|
|dev|다음 출시 버전을 개발하는 브랜치|
|feat|기능을 개발하는 브랜치|

</div>
</details>

</br>
