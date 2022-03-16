package ru.webinnovations.flowabletemplatedemo.controllers;

import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.webinnovations.flowabletemplatedemo.entities.Order;
import ru.webinnovations.flowabletemplatedemo.repositories.OrderRepository;
import ru.webinnovations.flowabletemplatedemo.services.OrderService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : maoz (mao_z@mail.ru)
 **/
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired OrderRepository orderRepository;
    @Autowired OrderService orderService;
    @Autowired private TaskService taskService;

    @GetMapping("/")
    public List<Order> list() {
        return orderRepository.findAll();
    }

    @PostMapping("/")
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @GetMapping("/awaiting")
    public Map<String, Object> awaiting() {
        return taskService.createTaskQuery().list()
                .stream()
                .collect(Collectors.toMap(Task::getId,
                        t -> taskService.getVariable(t.getId(), "order")
                ));
    }

    @PostMapping("/accept/{taskId}")
    public Order acceptOrder(@PathVariable String taskId) {
        return orderService.acceptOrder(taskId);
    }
}
