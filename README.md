<p align="center">
 <img width="100px" src="https://res.cloudinary.com/anuraghazra/image/upload/v1594908242/logo_ccswme.svg" align="center" alt="GitHub Readme Stats" />
    <h2 align="center">[Calculator_Main] 기능성 계산기</h2>
</p>
<br/>

<h2>목차</h2>

- [📜 소개](#소개)
- [👨‍👧‍👦 팀원](#팀원)
- [⚙️ 개발 환경](#개발-환경)
- [🎲 기능 목록](#기능-목록)
- [🧩 핵심 기능](#핵심-기능)
- [✍ Trouble Shooting](https://kyunghun0515.tistory.com/30)
<br/>

<h2>소개</h2>

이 프로젝트는 간단한 계산기 애플리케이션으로, 사용자가 덧셈, 뺄셈, 곱셈, 나눗셈 등의 기본적인 산술 연산을 수행할 수 있는 기능을 제공합니다. 또한, 사용자 친화적인 인터페이스와 직관적인 사용 방법을 제공하여 누구나 쉽게 사용할 수 있습니다. 이 애플리케이션은 계산 기능뿐만 아니라, 잘못된 연산 입력에 대한 에러 처리와 입력 초기화 기능도 지원합니다. 이 프로젝트는 Java로 개발되었으며, Git을 사용하여 버전 관리를 하였습니다.

주요 기능은 아래와 같습니다:

- 기본 산술 연산: 덧셈, 뺄셈, 곱셈, 나눗셈

- 에러 처리: 잘못된 입력(예: 0으로 나누기)에 대한 에러 메시지 제공

- 사용자 인터페이스: 직관적이고 쉽게 사용할 수 있는 UI

- 초기화 기능: 계산기 입력값 초기화 및 리셋
<br/>

## 개발 환경
- JAVA
- GIT
<br/>

## 팀원

<table>
   <tr>
    <td align="center"><b><a href="https://github.com/kyung412820">이경훈</a></b></td>
  <tr>
    <td align="center"><a href="https://github.com/kyung412820"><img src="https://avatars.githubusercontent.com/u/71320521?v=4" width="100px" /></a></td>
  </tr>
  <tr>
    <td align="center"><b>프로젝트 총괄</b></td>
</table>
<br/>


## 기능 목록

기본 산술 연산

 - 덧셈, 뺄셈, 곱셈, 나눗셈 연산 기능을 제공.
두 숫자를 입력하고 연산을 선택하여 결과를 계산.
입력 초기화

 - 사용자가 입력한 값을 초기화하여 새로운 연산을 시작할 수 있음.
"초기화" 버튼을 클릭하여 현재 입력값을 초기화.
결과 표시

 - 연산 결과를 실시간으로 화면에 표시.
계산된 결과를 사용자가 바로 확인할 수 있음.
에러 처리

 - 나누기 0과 같은 잘못된 연산에 대한 에러 메시지 제공.
에러가 발생하면 사용자에게 오류 메시지가 화면에 표시됨.
사용자 친화적인 UI

 - 직관적인 사용자 인터페이스로 누구나 쉽게 사용할 수 있음.
버튼과 화면 구성 요소가 명확하게 배치되어 사용자의 편의성 제공.
소수점 연산 지원

 - 실수 연산을 지원하여 소수점 계산도 가능.
이전 계산 결과 기억

 - 이전 계산 결과를 자동으로 저장하고, 다시 사용할 수 있음.
<br/>

## 핵심 기능

#### Lv 1: 기본적인 연산 수행 

 - Scanner: 사용자로부터 입력을 받기 위해 사용.

 - 조건문 (if, switch): 사칙연산 기호에 맞춰 조건을 처리.

 - 반복문 (while, for): 무한 반복 계산 기능을 구현.

기술 활용:

 - Scanner로 양의 정수 2개와 사칙연산 기호를 입력받아, 이를 조건문을 사용하여 연산 후 결과를 출력.

 - 연산 결과를 출력하고, "exit" 입력 시 반복문 종료.

------------------------------------------------------------------------

#### Lv 2: 클래스 적용한 계산기 만들기


 - 클래스: Calculator 클래스를 사용하여 연산 수행 및 결과 저장.

 - 메서드: 연산을 수행하는 메서드 및 결과를 반환하는 메서드 작성.

 - 컬렉션: 연산 결과를 저장하는 컬렉션 필드 구현 (List, ArrayList 등).

 - 캡슐화: Calculator 클래스의 연산 결과를 외부에서 직접 접근하지 않도록 Getter/Setter 메서드로 간접 접근.

기술 활용:

 - 연산을 수행하는 calculate 메서드를 Calculator 클래스에 구현.

 - 연산 결과를 List 컬렉션에 저장하여, 결과를 관리.

 - App 클래스에서 Calculator 클래스를 활용하여 연산하고, 결과를 출력.

------------------------------------------------------------------------

#### 3. 도전 기능: Enum, 제네릭, 람다 & 스트림

 - Enum: 연산자 타입(➕, ➖, ✖️, ➗)을 관리하는 Operation Enum을 사용.

 - 제네릭: ArithmeticCalculator 클래스를 제네릭으로 수정하여 다양한 타입의 연산을 처리할 수 있도록 함 (Integer, Double 등).

 - 람다 & 스트림: 결과 목록을 필터링하고 조회하는 메서드에 람다식과 스트림 API를 활용.

기술 활용:
 - Enum을 사용하여 연산자를 객체로 관리, Operation.ADD, Operation.SUBTRACT 등을 사용.

 - ArithmeticCalculator 클래스를 제네릭 타입으로 확장하여 실수(Double)와 정수(Integer) 연산을 모두 처리.

 - Stream과 Lambda를 사용하여 저장된 연산 결과 중 특정 조건을 만족하는 값만 조회.

------------------------------------------------------------------------

#### 4. 기타 기능

 - 오버로딩: 동일한 이름의 메서드를 매개변수 타입에 따라 여러 개 구현.

 - 예외 처리: 잘못된 입력에 대해 예외를 처리하여 사용자에게 명확한 오류 메시지 출력.

 - 정형 타입 매개변수: 제네릭을 활용하여 다양한 타입을 다룰 수 있는 메서드를 구현.

------------------------------------------------------------------------
<br/>

## Trouble Shooting

[https://kyunghun0515.tistory.com/manage/posts](https://kyunghun0515.tistory.com/30)
<br/>
<br/>
<br/>
<br/>
