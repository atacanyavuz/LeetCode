class Solution {
    public String simplifyPath(String path) {
        Stack<String> pathRoute = new Stack<String>();
        List<String> pathSplit = List.of(path.split("/"));

        for (int i = 0; i < pathSplit.size(); i++) {
            if (pathSplit.get(i).equals(".") || pathSplit.get(i).equals("")) {
                continue;
            }
            else if (pathSplit.get(i).equals("..")) {
                System.out.println(pathSplit.get(i) + "\t");
                if(pathRoute.size() > 0){
                    pathRoute.pop();
                }
            }
            else{
                pathRoute.push(pathSplit.get(i));
            }
        }
        if (pathRoute.size() == 0) {
            return "/";
        }

        String res = "";
        while (pathRoute.size() > 0) {
            res = "/" + pathRoute.pop()  + res;
        }

        return res;
    }
}