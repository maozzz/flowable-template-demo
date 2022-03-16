package ru.webinnovations.flowabletemplatedemo.services;

import lombok.extern.java.Log;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webinnovations.flowabletemplatedemo.entities.Order;
import ru.webinnovations.flowabletemplatedemo.repositories.OrderRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : maoz (mao_z@mail.ru)
 **/
@Service @Log
public class OrderService {

    @Autowired private RuntimeService runtimeService;
    @Autowired OrderRepository orderRepository;
    @Autowired private TaskService taskService;

    public Order create(Order order) {
        order = orderRepository.save(order);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("order", order);
        log.info("Создание заявки");
        runtimeService.startProcessInstanceByKey("createOrder", variables);
        return order;
    }

    public void processOrder() {
        log.info("Обработка заявки");
    }

    public void notificateSms() {
        log.info("Уведомление по СМС");
    }

    public void notificateEmail() {
        log.info("Уведомление по почте");
    }

    public Order acceptOrder(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).active().singleResult();
        Order order = (Order) taskService.getVariable(taskId, "order");
        taskService.complete(task.getId(), taskService.getVariables(task.getId()));
        return order;
    }
}
