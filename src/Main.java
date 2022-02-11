import java.util.*;

class Gem implements Comparable<Gem> {
    int m; // 무게
    int v; // 가격

    Gem(int m, int v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(Gem g) {
        if (this.m == g.m) {
            return g.v - this.v;
        }
        return this.m - g.m;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        PriorityQueue<Gem> pQ = new PriorityQueue<>();
        // 보석에 관한 정보
        for (int i = 0; i < n; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            pQ.offer(new Gem(a, b));
        }

        // 가방에 관한 정보
        int[] bag = new int[m];
        for (int i = 0; i < m; i++) {
            bag[i] = kb.nextInt();
        }
        Arrays.sort(bag);
        // 가방에 들어갈 수 있는 보석
        PriorityQueue<Integer> vQ = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;

        for (int i = 0; i < m; i++) {
            while (!pQ.isEmpty()) {
                if (bag[i] >= pQ.peek().m) {
                    vQ.offer(pQ.poll().v);
                } else {
                    break;
                }
            }
            // 가방에 들어있는 보석 중에서 가격이 가장 큰 값을 빼낸다
            if(!vQ.isEmpty()){
                total += vQ.poll();
            }
        }
        System.out.println(total);
    }
}
