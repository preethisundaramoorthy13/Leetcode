// Last updated: 7/17/2026, 3:02:57 PM
class Solution {

    private static final int[] DIGIT_MULTIPLIERS = {1, 10, 100, 1000};

    enum State {
        NOT_VISITED,
        DEAD,
        FORWARD,
        BACKWARD
    }

    enum Direction {
        FORWARD,
        BACKWARD
    }

    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        State[] state = new State[10_000];
        for (int i = 0; i < state.length; i++) {
            state[i] = State.NOT_VISITED;
        }

        for (String deadend : deadends) {
            state[Integer.parseInt(deadend)] = State.DEAD;
        }

        int sourceCombination = 0;
        int destinationCombination = Integer.parseInt(target);

        if (state[sourceCombination] == State.DEAD || state[destinationCombination] == State.DEAD) {
            return -1;
        }

        if (sourceCombination == destinationCombination) {
            return 0;
        }

        Queue<Integer> forwardQueue = new LinkedList<>();
        forwardQueue.offer(sourceCombination);
        state[sourceCombination] = State.FORWARD;

        Queue<Integer> backwardQueue = new LinkedList<>();
        backwardQueue.offer(destinationCombination);
        state[destinationCombination] = State.BACKWARD;

        Direction direction = Direction.FORWARD;
        int moves = 0; 

        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            
            if (forwardQueue.size() > backwardQueue.size()) {
                Queue<Integer> temp = forwardQueue;
                forwardQueue = backwardQueue;
                backwardQueue = temp;
                direction = direction == Direction.FORWARD ? Direction.BACKWARD : Direction.FORWARD;
            }

            moves++;

            for (int toProcess = forwardQueue.size(); toProcess > 0; toProcess--) {
                
                int combination = forwardQueue.poll();

                for (int multiplier : DIGIT_MULTIPLIERS) {
                    int digit = (combination / multiplier) % 10;

                    for (int delta = -1; delta <= 1; delta += 2) {

                        int newDigit = digit + delta;

                        if (newDigit == -1) newDigit = 9;
                        if (newDigit == 10) newDigit = 0;

                        int next = combination + (newDigit - digit) * multiplier;

                        State thisDirectionVisited = direction == Direction.FORWARD ? State.FORWARD : State.BACKWARD;
                        State anotherDirectionVisited = direction == Direction.FORWARD ? State.BACKWARD : State.FORWARD;
                        if (state[next] == anotherDirectionVisited) {
                            return moves;
                        }

                        if (state[next] == State.NOT_VISITED) {
                            forwardQueue.offer(next);
                            state[next] = thisDirectionVisited;
                        }
                    }
                }
            }

        }

        return -1;
    }
}