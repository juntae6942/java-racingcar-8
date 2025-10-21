# java-racingcar-precourse
# 주어진 요구 사항
초간단 자동차 경주 게임을 구현한다.

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
3항 연산자를 쓰지 않는다.
함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.

# 클래스별 요구사항 정리
## InputView
필드 : 이동 횟수
- 자동차 이름 입력 carNames()
- 차동차 이름 NameParser로 parse() 및 NameValidator로 검증 후 addCars()
반환 : 자동차 이름 리스트
- NumberValidator로 검증 후 repeatCount 초기화 initRepeatCount
- 반복횟수 반환 repeatCount()
## NumberValidator
- 입력받은 이동 횟수가 숫자인지 확인 validateNumber() 아닐 경우 IllegalArgumentException

## NameParser
- 자동차 이름 분리 parse()
반환 : 자동차 이름 리스트

## NameValidator
- 자동차 이름 검증(5자 이하인지) validateName()
예외 처리 : 5글자 이상이면 IllegalArgumentException 혹은 "" 빈문자열이 자동차 이름인 경우도 IllegalArgumentException

## OutputView
- 경기 결과 출력 finalResult()

## Car
필드 : 이름, 이동 거리
- MovementChecker로 받은 값으로 이동 여부 결정 
- 전진 move()

## MovementChecker
- 이동 가능여부 결정 canMove()

## RacingGame
- 이동 횟수 입력 받아서 경주 진행 race()
- 경기 중간 상황 출력 showRoundStatus()

## Referee
- 최종 우승자 결정 findWinner()

## Application
InputView -> RacingGame -> Referee -> OutputView