// Last updated: 7/17/2026, 3:04:59 PM
class Solution {
    int ind;
    public int evalRPN(String[] tokens) {
        ind = tokens.length-1;
        return evals(tokens);
    }

    public int evals(String[] tokens){
        return switch(tokens[ind--]){
            case "+" -> evals(tokens) + evals(tokens);
            case "*" -> evals(tokens) * evals(tokens);
            case "-" -> {
                int a = evals(tokens);
                yield evals(tokens) - a;
            }
            case "/" -> {
                int a = evals(tokens);
                yield evals(tokens) / a;
            }
            default -> Integer.parseInt(tokens[ind+1]);
        };
    }
}