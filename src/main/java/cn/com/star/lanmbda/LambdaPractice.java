package cn.com.star.lanmbda;


import cn.com.star.lanmbda.mock.MockUtil;
import cn.com.star.lanmbda.model.Trader;
import cn.com.star.lanmbda.model.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用Lambda解决下列问题：
 * <p>
 * 找出2011年发生的所有交易，并按交易额排序
 * <p>
 * 交易员在哪些不同的城市工作过
 * <p>
 * 查找所有来自剑桥的交易员，并按姓名排序
 * <p>
 * 返回所有交易员的姓名字符串，并按字母顺序排序
 * <p>
 * 有没有交易员在米兰工作的？
 * <p>
 * 打印生活在剑桥的交易员的所有交易额
 * <p>
 * 所有交易中，最高的交易额是多少
 * <p>
 * 交易人员Raoul的总额度
 */
public class LambdaPractice {
    public static void main(String[] args) {
        LambdaPractice lambdaPractice = new LambdaPractice();
        lambdaPractice.getTransactionByYearAndSorted();
        lambdaPractice.getDifferentCity();
        lambdaPractice.getTraderByCityAndSorted();
        lambdaPractice.getTraderNameAndSorted();
        lambdaPractice.hasTraderWorikInMiLan();
        lambdaPractice.printTarderAmount();
        lambdaPractice.getTheHighestAmount();
        lambdaPractice.getTraderTotalAmount();
        //just for others demo
        lambdaPractice.generateHours();
    }

    private void generateHours() {
        List numbers = Stream.iterate(0, n -> n + 1)
                .limit(60)
                .map(n -> String.format("%02d", n))
                .collect(Collectors.toList());
    }

    /**
     * 找出2011年发生的所有交易，并按交易额排序(从大到小)
     */
    private void getTransactionByYearAndSorted() {
        List<Transaction> listTransaction = MockUtil.getTransactionList();
        listTransaction.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .forEach(transaction -> System.out.println("交易时间=" + transaction.getYear() + " 交易额=" + transaction.getAmount() + " 交易人员=" + transaction.getTrader().getTraderName()));
    }

    /**
     * 交易员在不同城市工作
     */
    private void getDifferentCity() {
        List<Transaction> listTransaction = MockUtil.getTransactionList();
        String workCity = listTransaction.stream()
                .map(transaction -> transaction.getTrader().getCity()).distinct()
                .collect(Collectors.joining(","));
        System.out.println("交易员工作的城市" + workCity);
    }

    /**
     * 查找所有来自剑桥的交易员，并按姓名排序
     */
    private void getTraderByCityAndSorted() {
        List<Transaction> listTransaction = MockUtil.getTransactionList();
        listTransaction.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader).distinct()
                .sorted(Comparator.comparing(Trader::getTraderName))
                .forEach(trader -> System.out.println("交易城市=" + trader.getCity() + " 交易人员=" + trader.getTraderName()));
    }


    /**
     * 返回所有交易员的姓名字符串，并按字母顺序排序
     */
    private void getTraderNameAndSorted() {
        List<Transaction> listTransaction = MockUtil.getTransactionList();
        listTransaction.stream()
                .map(Transaction::getTrader).distinct()
                .sorted(Comparator.comparing(Trader::getTraderName))
                .forEach(trader -> System.out.println("交易人员=" + trader.getTraderName()));
    }

    /**
     * 有没有交易员在米兰工作的？
     */
    private void hasTraderWorikInMiLan() {
        List<Transaction> listTransaction = MockUtil.getTransactionList();
        listTransaction.stream()
                .map(Transaction::getTrader).distinct()
                .filter(trade -> trade.getCity().equals("Milan"))
                .forEach(trader -> System.out.println("交易人员=" + trader.getTraderName() + "工作城市在=" + trader.getCity()));
        //或者这样写
        boolean workInMilan = listTransaction.stream()
                .map(Transaction::getTrader).distinct()
                .anyMatch(trade -> trade.getCity().equals("Milan"));
        if (workInMilan) {
            System.out.println("存在在米兰工作的人员");
        }
    }

    /**
     * 打印生活在剑桥的交易员的所有交易额
     */
    private void printTarderAmount() {
        List<Transaction> listTransaction = MockUtil.getTransactionList();
        listTransaction.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .forEach(transaction -> System.out.println("交易人员=" + transaction.getTrader().getTraderName() + "交易额度=" + transaction.getAmount()));
    }

    /**
     * 所有交易中，最高的交易额是多少
     */

    private void getTheHighestAmount() {
        List<Transaction> listTransaction = MockUtil.getTransactionList();
        Optional<Integer> hightestAmount = listTransaction.stream()
                .map(Transaction::getAmount)
                .reduce(Integer::max);
        System.out.println("所有交易员中最高交易额" + hightestAmount.get());
    }

    /**
     * 交易人员Raoul的总额度
     */
    private void getTraderTotalAmount() {
        List<Transaction> listTransaction = MockUtil.getTransactionList();
        Double totalAmount = listTransaction.stream()
                .filter(transaction -> transaction.getTrader().getTraderName().equals("Raoul"))
                .mapToDouble(Transaction::getAmount).sum();
        System.out.println("交易员 Raoul 交易总额 = " + totalAmount);
    }
}
