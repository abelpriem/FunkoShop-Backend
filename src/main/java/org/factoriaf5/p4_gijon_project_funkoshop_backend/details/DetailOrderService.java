package org.factoriaf5.p4_gijon_project_funkoshop_backend.details;

import java.util.List;

import org.factoriaf5.p4_gijon_project_funkoshop_backend.order.Order;
import org.factoriaf5.p4_gijon_project_funkoshop_backend.order.OrderDto;
import org.factoriaf5.p4_gijon_project_funkoshop_backend.order.OrderRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

@Service
public class DetailOrderService {

    // UserRepository userRepository;
    OrderRepository orderRepository;

    public List<DetailOrderDto> getSales(String authorizationHeader) {
        String token = authorizationHeader.substring(7);
        String emailToken = jwtUtil.extractEmailFromToken(token);

        User user = userRepository.findByEmail(emailToken)
                .orElseThrow(() -> new IllegalArgumentException("Usuario del token no encontrado"));

        if (!token.equals(user.getToken(token)) && !"admin".equals(user.getRoles())) {
            throw new SecurityException("Acceso denegado. Solo el ADMIN puede realizar la acción");
        }

        List<Order> order = orderRepository.findAll().stream().filter();

    }

    public List<OrderDto> listByMonth(String authorizationHeader) {
        String token = authorizationHeader.substring(7);
        String emailToken = jwtUtil.extractEmailFromToken(token);

        User user = userRepository.findByEmail(emailToken)
                .orElseThrow(() -> new IllegalArgumentException("Usuario del token no encontrado"));

        if (!token.equals(user.getToken(token)) && !"admin".equals(user.getRoles())) {
            throw new SecurityException("Acceso denegado. Solo el ADMIN puede realizar la acción");
        }

        List<OrderDto> orderDto = OrderRepository.findAll().stream().filter(x -> x.getOrderDate).toList();

    }
//     import java.time.LocalDate;
// import java.time.temporal.TemporalAdjusters;
// import java.util.List;
// import java.util.stream.Collectors;

// public List<OrderDto> listByMonth(String authorizationHeader) {
//     String token = authorizationHeader.substring(7);  // Extrae el token
//     String emailToken = jwtUtil.extractEmailFromToken(token);

//     // Buscar al usuario por email extraído del token
//     User user = userRepository.findByEmail(emailToken)
//             .orElseThrow(() -> new IllegalArgumentException("Usuario del token no encontrado"));

//     // Verificar si el token es válido o si el usuario tiene rol de admin
//     if (!token.equals(user.getToken(token)) && !"admin".equals(user.getRoles())) {
//         throw new SecurityException("Acceso denegado. Solo el ADMIN puede realizar la acción");
//     }

//     // Obtener la fecha actual
//     LocalDate now = LocalDate.now();

//     // Calcular el primer día del mes pasado
//     LocalDate firstDayOfLastMonth = now.minusMonths(1).withDayOfMonth(1);

//     // Calcular el último día del mes pasado
//     LocalDate lastDayOfLastMonth = now.withDayOfMonth(1).minusDays(1);

//     // Filtrar las órdenes para obtener solo las del último mes
//     List<OrderDto> orderDto = OrderRepository.findAll().stream()
//             .filter(order -> {
//                 // Verifica que la fecha de la orden esté dentro del mes pasado
//                 LocalDate orderDate = order.getOrderDate();  // Asumiendo que getOrderDate() devuelve un LocalDate o LocalDateTime
//                 return !orderDate.isBefore(firstDayOfLastMonth) && !orderDate.isAfter(lastDayOfLastMonth);
//             })
//             .map(order -> new OrderDto(order))  // Mapea las órdenes a OrderDto
//             .collect(Collectors.toList());

//     return orderDto;
// }
}
