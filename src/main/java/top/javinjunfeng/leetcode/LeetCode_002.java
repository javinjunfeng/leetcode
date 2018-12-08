package top.javinjunfeng.leetcode;

/**
 * @Author: javinjunfeng
 * @Date: 2018/12/8 4:14 PM
 * @Version 1.0
 */
public class LeetCode_002 {
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        int mod =0;
        int res =0;
        int except =0;

        ListNode reNode = resultNode;

        while (null != l1){
            if (null != l2){
                res = l1.val + l2.val + except;
            }else {
                res = l1.val + except;
            }
            if (res>=10){
                mod = res % 10;
                except = res / 10;
            }else {
                mod = res;
                except = 0;
                res = 0;
            }
            l1.val = mod;

            reNode.next = l1;
            l1 = l1.next;
            if (null != l2){
                l2 = l2.next;
            }
            reNode = reNode.next;
        }

        if (null != l2){
            if (0==except ){
                reNode.next = l2;
            }else {
                while (null != l2){
                    res = l2.val + except;
                    if (res<10){
                        l2.val=res;
                        reNode.next = l2;
                        except = 0;
                        break;
                    }else{
                        mod = res % 10;
                        except = res / 10;
                    }
                    l2.val = mod;

                    reNode.next = l2;
                    l2 = l2.next;
                    reNode = reNode.next;
                }
                if (0!= except){
                    reNode.next = new ListNode(except);
                }
            }
        }else if (0!= except){
            reNode.next = new ListNode(except);
        }

        return resultNode.next;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(5);
//        listNode1.next = new ListNode(6);
//        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
//        listNode2.next = new ListNode(4);
//        listNode2.next.next = new ListNode(8);

        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode1);
        System.out.println(listNode2);
        System.out.println(listNode);
    }
}

class ListNode {
int val;
ListNode next;
ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val + (null == next ? "":"->" + next);
    }
}
