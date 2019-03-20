package domain;

import java.util.List;

public class Lotto {
    private Numbers numbers;

    public static Lotto generateLotto(List<Integer> integers) {
        Lotto lotto = new Lotto();
        lotto.numbers = new Numbers(integers);
        return lotto;
    }

    public LottoResultStatus getLottoResultStatus(int[] winningNumbers) {
        int containsWinningNumberCount = 0;
        for (int number : winningNumbers) {
            if(numbers.contains(number))
                containsWinningNumberCount ++;
        }

        return setResultByContainCount(containsWinningNumberCount);
    }

    private LottoResultStatus setResultByContainCount(int matchCount) {
        if ( matchCount < 3) {
            return LottoResultStatus.NONE;
        }

        return LottoResultStatus.of(matchCount);
    }

    public Numbers getNumbers() {
       return this.numbers;
    }

}
