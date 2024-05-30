package Assignment_one;

class Task {
    private String title;
    private String description;
    private boolean completed;

    // Constructor to initialize a task with a title and description
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    // Getter method to retrieve the title of the task
    public String getTitle() {
        return title;
    }

    // Getter method to retrieve the description of the task
    public String getDescription() {
        return description;
    }

    // Getter method to check if the task is completed
    public boolean isCompleted() {
        return completed;
    }

    // Method to mark the task as completed
    public void markCompleted() {
        this.completed = true;
    }
}

class Node {
    public Task task;
    public Node next;

    // Constructor to initialize a node with a task
    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class ToDoList {
    public  Node head;

    // Method to add a new task to the end of the linked list
    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to mark a task as completed based on its title
    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                return;
            }
            current = current.next;
        }
    }

    // Method to display the list of tasks in the to-do list
    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            System.out.println("Title: " + current.task.getTitle());
            System.out.println("Description: " + current.task.getDescription());
            System.out.println("Completed: " + (current.task.isCompleted() ? "Yes" : "No"));
            System.out.println();
            current = current.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        Task task1 = new Task("Task 1", "This is the first task");
        Task task2 = new Task("Task 2", "This is the second task");
        Task task3 = new Task("Task 3", "This is the third task");

        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);

        toDoList.viewToDoList();

        toDoList.markToDoAsCompleted("Task 1");

        toDoList.viewToDoList();
    }
}