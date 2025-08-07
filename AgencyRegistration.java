import java.util.*;

public class AgencyRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<String> idStack = new Stack<>();
        String[] ids = scanner.nextLine().split(" ");
        for (String id : ids) {
            idStack.push(id);
        }
        Queue<String> agentsQueue = new ArrayDeque<>();
        String[] agents = scanner.nextLine().split(" ");
        for (String agent : agents) {
            agentsQueue.offer(agent);
        }
        
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            if (command.startsWith("add-ID ")) {
                String newID = command.substring(7);
                idStack.push(newID);
            } else if (command.startsWith("add-agent ")) {
                String agentName = command.substring(10);
                agentsQueue.offer(agentName);
            } else if (command.equals("remove-ID")) {
                if (!idStack.isEmpty()) {
                    String removedID = idStack.pop();
                    System.out.println(removedID + " has been removed.");
                }
            } else if (command.equals("remove-agent")) {
                if (!agentsQueue.isEmpty()) {
                    String removedAgent = ((ArrayDeque<String>) agentsQueue).pollLast();
                    System.out.println(removedAgent + " has left the queue.");
                }
            } else if (command.equals("sort-ID")) {
                List<String> sorted = new ArrayList<>(idStack);
                sorted.sort(Collections.reverseOrder());
                idStack.clear();
                for (String id : sorted) {
                    idStack.push(id);
                }
            }

        }
        while (!agentsQueue.isEmpty() && !idStack.isEmpty()) {
            String agent = agentsQueue.poll();
            String id = idStack.pop();
            System.out.println(agent + " takes ID number: " + id);
        }

        while (!agentsQueue.isEmpty()) {
            String agent = agentsQueue.poll();
            System.out.println(agent + " does not have an ID.");
        }
        
        if (!idStack.isEmpty()) {
            System.out.println("No more agents left.");
            while (!idStack.isEmpty()) {
                System.out.println("ID number: " + idStack.pop());
            }
        }
    }
}
