import java.util.*;

public class SofaProblem {
    final public static int diff[] = { 0, 1, 0, -1, 0 };

    public static class Sofa {
        int fsr, fsc, ssr, ssc;
        char dir;
        int moves;

        public Sofa(int fsr, int fsc, int ssr, int ssc, char dir, int moves) {
            this.fsr = fsr;
            this.fsc = fsc;
            this.ssr = ssr;
            this.ssc = ssc;
            this.dir = dir;
            this.moves = moves;
        }

        public Sofa(int fsr, int fsc, int ssr, int ssc, char dir) {
            this.fsr = fsr;
            this.fsc = fsc;
            this.ssr = ssr;
            this.ssc = ssc;
            this.dir = dir;
        }
    }

    public static boolean isfree(int r, int c, char[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }
        return grid[r][c] != 'H';
    }

    public static Sofa up(Sofa s, int r, int c, char grid[][], Set<String> visited) {
        if (s.dir == 'v') {
            int newr = s.fsr - 1;
            String v = newr + "_" + s.fsc + "_" + s.ssr + "_" + s.ssc;
            if (newr >= 0 && newr < r && grid[newr][s.fsc] != 'H' && !visited.contains(v)) {
                visited.add(v);
                return new Sofa(newr, s.fsc, s.fsr, s.ssc, s.dir, s.moves + 1); /* like=> (1,2)&(2,2) => (0,2)&(1,2) */
            }
        } else {
            int fnr = s.fsr - 1;
            int snr = s.ssr - 1;
            String v = fnr + "_" + s.fsc + "_" + snr + "_" + s.ssc;
            if (fnr >= 0 && fnr < r && snr >= 0 && snr < r && grid[fnr][s.fsc] != 'H' && grid[snr][s.ssc] != 'H'
                    && !visited.contains(v)) {
                visited.add(v);
                return new Sofa(fnr, s.fsc, snr, s.ssc, s.dir, s.moves + 1);
            }
        }
        return null;
    }

    public static Sofa down(Sofa s, int r, int c, char grid[][], Set<String> visited) {
        if (s.dir == 'v') {
            int newr = s.ssr + 1;
            String v = s.ssr + "_" + s.fsc + "_" + newr + "_" + s.ssc;
            if (newr >= 0 && newr < r && grid[newr][s.ssc] != 'H' && !visited.contains(v)) {
                visited.add(v);
                return new Sofa(s.ssr, s.fsc, newr, s.ssc, s.dir, s.moves + 1);
            }
        } else {
            int fnr = s.fsr + 1;
            int snr = s.ssr + 1;
            String v = fnr + "_" + s.fsc + "_" + snr + "_" + s.ssc;
            if (fnr >= 0 && fnr < r && snr >= 0 && snr < r && grid[fnr][s.fsc] != 'H' && grid[snr][s.ssc] != 'H'
                    && !visited.contains(v)) {
                visited.add(v);
                return new Sofa(fnr, s.fsc, snr, s.ssc, s.dir, s.moves + 1);
            }
        }
        return null;
    }

    public static Sofa left(Sofa s, int r, int c, char grid[][], Set<String> visited) {
        if (s.dir == 'v') {
            int fnc = s.fsc - 1;
            int snc = s.ssc - 1;
            String v = s.fsr + "_" + fnc + "_" + s.ssr + "_" + snc;
            if (fnc >= 0 && fnc < c && snc < c && snc >= 0 && grid[s.fsr][fnc] != 'H' && grid[s.ssr][snc] != 'H'
                    && !visited.contains(v)) {
                visited.add(v);
                return new Sofa(s.fsr, fnc, s.ssr, snc, s.dir, s.moves + 1);
            }

        } else {
            int newc = s.fsc - 1;
            String v = s.fsr + "_" + newc + "_" + s.ssr + "_" + s.fsc;
            if (newc >= 0 && newc < c && grid[s.fsr][newc] != 'H' && !visited.contains(v)) {
                visited.add(v);
                return new Sofa(s.fsr, newc, s.ssr, s.fsc, s.dir, s.moves + 1);
            }
        }
        return null;
    }

    public static Sofa right(Sofa s, int r, int c, char grid[][], Set<String> visited) {
        if (s.dir == 'v') {
            int fnc = s.fsc + 1;
            int snc = s.ssc + 1;
            String v = s.fsr + "_" + fnc + "_" + s.ssr + "_" + snc;
            if (fnc >= 0 && fnc < c && snc < c && snc >= 0 && grid[s.fsr][fnc] != 'H' && grid[s.ssr][snc] != 'H'
                    && !visited.contains(v)) {
                visited.add(v);
                return new Sofa(s.fsr, fnc, s.ssr, snc, s.dir, s.moves + 1);
            }

        } else {
            int newc = s.ssc + 1;
            String v = s.fsr + "_" + s.ssc + "_" + s.ssr + "_" + newc;
            if (newc >= 0 && newc < c && grid[s.ssr][newc] != 'H' && !visited.contains(v)) {
                visited.add(v);
                return new Sofa(s.fsr, s.ssc, s.ssr, newc, s.dir, s.moves + 1);
            }
        }
        return null;
    }

    public static void rotate(Sofa s, int r, int c, char[][] grid, Set<String> visited, Queue<Sofa> q) {
        // clockwise - 2
        if (s.fsr - 1 >= 0 && s.fsr - 1 < r && s.fsc + 1 >= 0 && s.fsc + 1 < c) {
            String v1 = (s.fsr - 1) + "_" + (s.fsc + 1) + "_" + s.ssr + "_" + s.ssc;
            if (isfree(s.fsr - 1, s.fsc, grid) && isfree(s.fsr - 1, s.fsc + 1, grid) && !visited.contains(v1)) {
                q.add(new Sofa(s.fsr - 1, s.fsc + 1, s.ssr, s.ssc, (s.fsr - 1 == s.ssr ? 'h' : 'v'), s.moves + 1));
                visited.add(v1);
            }
        }

        if (s.ssr + 1 >= 0 && s.ssr + 1 < r && s.ssc - 1 >= 0 && s.ssc - 1 < c) {
            String v2 = s.fsr + "_" + s.fsc + "_" + (s.ssr + 1) + "_" + (s.ssc + 1);
            if (isfree(s.ssr + 1, s.ssc, grid) && isfree(s.ssr + 1, s.ssc - 1, grid) && !visited.contains(v2)) {
                q.add(new Sofa(s.fsr, s.fsc, s.ssr + 1, s.ssc - 1, (s.fsr == (s.ssr + 1) ? 'h' : 'v'), s.moves + 1));
                visited.add(v2);
            }
        }

        // anti-clockwise - 2
        if (s.fsr + 1 >= 0 && s.fsr + 1 < r && s.fsc + 1 >= 0 && s.fsc + 1 < c) {
            String v3 = (s.fsr + 1) + "_" + (s.fsc + 1) + "_" + s.ssr + "_" + s.ssc;
            if (isfree(s.fsr + 1, s.fsc, grid) && isfree(s.fsr + 1, s.fsc + 1, grid) && !visited.contains(v3)) {
                q.add(new Sofa(s.fsr + 1, s.fsc + 1, s.ssr, s.ssc, (s.fsr + 1 == s.ssr ? 'h' : 'v'), s.moves + 1));
                visited.add(v3);
            }
        }

        if (s.ssr - 1 >= 0 && s.ssr - 1 < r && s.ssc - 1 >= 0 && s.ssc - 1 < c) {
            String v4 = s.fsr + "_" + s.fsc + "_" + (s.ssr - 1) + "_" + (s.ssc - 1);
            if (isfree(s.ssr - 1, s.ssc, grid) && isfree(s.ssr - 1, s.ssc - 1, grid) && !visited.contains(v4)) {
                q.add(new Sofa(s.fsr, s.fsc, s.ssr - 1, s.ssc - 1, (s.fsr == s.ssr - 1 ? 'h' : 'v'), s.moves + 1));
                visited.add(v4);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();

        char grid[][] = new char[r][c];
        int fsr = -1, fsc = -1, fdr = -1, fdc = -1, ssr = -1, ssc = -1, sdr = -1, sdc = -1;
        boolean flag = false, dflag = false;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.next().charAt(0);
                if (grid[i][j] == 's' && !flag) {
                    fsr = i;
                    fsc = j;
                    flag = !flag;
                }
                if (grid[i][j] == 'S' && !dflag) {
                    fdr = i;
                    fdc = j;
                    dflag = !dflag;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int ar = fsr + diff[i];
            int ac = fsc + diff[i + 1];
            if (ar < r && ar >= 0 && ac < c && ac >= 0 && grid[ar][ac] == 's') {
                ssr = ar;
                ssc = ac;
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            int ar = fdr + diff[i];
            int ac = fdc + diff[i + 1];
            if (ar < r && ar >= 0 && ac < c && ac >= 0 && grid[ar][ac] == 'S') {
                sdr = ar;
                sdc = ac;
                break;
            }
        }
        char orientation;

        if (fsr == ssr) {
            orientation = 'h';
        } else {
            orientation = 'v';
        }
        Sofa start = new Sofa(fsr, fsc, ssr, ssc, orientation, 0);

        if (fdr == sdr) {
            orientation = 'h';
        } else {
            orientation = 'v';
        }
        Sofa target = new Sofa(fdr, fdc, sdr, sdc, orientation);

        Queue<Sofa> q = new LinkedList<>();
        q.add(start);

        Set<String> visited = new HashSet<>(); // gonna store the visited indices as string
        visited.add(start.fsr + "_" + start.fsc + "_" + start.ssr + "_" + start.ssc); // eg: 1_2_1_3

        while (!q.isEmpty()) {
            Sofa curr = q.poll();

            if (curr.fsr == target.fsr && curr.fsc == target.fsc && curr.ssr == target.ssr && curr.ssc == target.ssc) {
                System.out.println(curr.moves);
                sc.close();
                return;
            }
            Sofa next;

            next = up(curr, r, c, grid, visited);
            if (next != null) {
                q.add(next);
            }

            next = down(curr, r, c, grid, visited);
            if (next != null) {
                q.add(next);
            }

            next = left(curr, r, c, grid, visited);
            if (next != null) {
                q.add(next);
            }

            next = right(curr, r, c, grid, visited);
            if (next != null) {
                q.add(next);
            }
            rotate(curr, r, c, grid, visited, q);
        }

        System.out.println("Impossible");
        sc.close();
    }
}