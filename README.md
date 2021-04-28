# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

이하 기능 요구사항, 프로그래밍 요구사항, 요구사항 분석 순으로 이어집니다.

---

## 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 프로그램 실행 결과

```text
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
시도할 횟수는 몇회인가요?
5

실행 결과
pobi : -
crong: -
honux: -

pobi : --
crong: -
honux: --

pobi : ---
crong: --
honux: ---

pobi : ----
crong: ---
honux: ----

pobi : -----
crong: ----
honux: -----

pobi, honux가 최종 우승했습니다.
```

## 프로그래밍 요구사항

### 1주차와 동일한 기준

- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - https://naver.github.io/hackday-conventions-java/
    - indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.

### 2주차 추가 요구사항

- 일급콜렉션을 활용해 구현한다.
    - 참고문서: https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
- 모든 원시값과 문자열을 포장한다.
    - 참고문서: https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4

### 단위 테스트

- 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in, Scanner) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf" 문서를 참고해 사용법을 익힌 후 JUnit5 기반 단위
  테스트를 구현한다.

---

## 요구사항 분석

1. 자동차 생성
    - 자동차 이름은 입력받아야 하며 쉼표로 구분한다.
    - 입력한 이름의 개수만큼 자동차가 생성된다.
2. 자동차 전진
    - 전진 시도 횟수는 입력받는다.
    - 전진은 할 수도, 안할 수도 있다.
3. 자동차 전진 여부 결정
    - 전진 여부는 무작위로 선정한다.
4. 게임 관리자
    - 게임 시작 및 전진을 진행하는 주체이다.
5. 결과 출력
    - 각 자동차의 이름을 먼저 출력한다.
    - 자동차가 전진한 횟수만큼 `-`를 화면에 출력한다.
    - ex
      ```
      자동차1: ----
      자동차2: --
      자동차3: ---
      ```
