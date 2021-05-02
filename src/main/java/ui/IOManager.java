package ui;

import java.util.List;

public class IOManager {

    private final Input input;
    private final Output output;

    public IOManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public static IOManager defaultIOManager() {
        return new IOManager(new StandardInput(), new StandardOutput());
    }

    public String inputNames() {
        return input.nextLine();
    }

    public int inputTryCount() {
        return input.nextInt();
    }

    public void printInputNames() {
        output.printLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
    }

    public void printInputTryCount() {
        output.printLine("시도할 횟수는 몇 회인가요?");
    }

    public void printStatus(List<String> carsStatus) {
        carsStatus.forEach(output::printLine);
        output.printLine("");
    }

    public void printResult(String winners) {
        output.printLine(winners + "가 최종 우승했습니다.");
    }
}
