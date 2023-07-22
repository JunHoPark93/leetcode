class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // one stack
        // loop asteroids 
        // push each elems
        // cal
        // - +
        // - - 
        // + - (collision)
        //  -> pop -> calculate -> determine push or not
        // + +

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int elem = asteroids[i];
            if (stack.isEmpty()) {
                stack.push(elem);
                continue;
            }
            int peekedAst = stack.peek();
            if (elem < 0 && peekedAst > 0) {
                cal(stack, elem);
                
            } else {
                stack.push(elem);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        Collections.reverse(result);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void cal(Stack<Integer> stack, int elem) {
        int ast = stack.pop();
        if (Math.abs(elem) < ast) {
            // 한번에 끝나는 경우 
            stack.push(ast);
        } else if (Math.abs(elem) > ast) {
            // elem이 이긴경우
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(elem);
                    break;
                }
                int peek = stack.peek();
                if (peek > 0) {
                    if (Math.abs(elem) < peek) {
                        break;
                    } else if (Math.abs(elem) == peek) {
                        stack.pop();
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(elem);
                    break;
                }
            }
        } 
    }
}