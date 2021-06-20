package hongik.corestudy100;

import hongik.corestudy100.member.Grade;
import hongik.corestudy100.member.Member;
import hongik.corestudy100.member.MemberService;
import hongik.corestudy100.member.MemberServiceImpl;
import hongik.corestudy100.order.Order;
import hongik.corestudy100.order.OrderService;
import hongik.corestudy100.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000);
        System.out.println("order = " + order);

    }
}
