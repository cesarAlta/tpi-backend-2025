# TPI-Backend: Container Transport Management System

## Architecture Overview

This is a **microservices-based logistics system** for container transportation management using Spring Boot ecosystem. The system orchestrates the entire lifecycle of container transport requests from client submission to delivery tracking.

### Core Domain Model
- **Transport Request Lifecycle**: `BORRADOR → PROGRAMADA → EN_TRANSITO → ENTREGADA`
- **Route Composition**: Routes are decomposed into segments that can use different trucks and pass through multiple depots
- **Segment Types**: `ORIGEN-DEP`, `DEP-DEP`, `DEP-DEST`, `ORIGEN-DEST` (see `DER.puml` Segment table)
- **Multi-modal Routing**: Routes can chain through multiple depots for complex logistics scenarios

### Microservice Architecture (Spring Boot + MySQL per service)

**Core Services**:
- `solicitud-service`: Orchestrates the request lifecycle, coordinates with other services
- `ruta-service`: **Complex routing engine** - calculates multi-depot routes, integrates Google Maps API, handles truck capacity constraints
- `contenedor-service`: Container management with weight/volume validation against tariff ranges
- `cliente-service`: Client CRUD operations
- `camion-service`: Truck fleet management with availability tracking
- `deposito-service`: Depot management with geolocation (lat/lng)
- `tarifa-service`: Dynamic pricing based on volume/weight ranges

**Infrastructure**:
- `Spring Cloud Gateway`: Single entry point with JWT validation
- `Keycloak`: Role-based auth (cliente, operador, transportista)

## Key Development Patterns

### Service Communication
- **Synchronous REST**: Service-to-service calls via Spring RestTemplate/WebClient
- **Request Orchestration**: `solicitud-service` coordinates with `cliente-service`, `contenedor-service`, and `ruta-service`
- **Route Calculation Flow**: `ruta-service` → `deposito-service` (depot locations) → `camion-service` (capacity filtering) → `tarifa-service` (cost estimation)

### Domain-Specific Constraints
- **Truck Capacity Validation**: Always check `max_weight_kg` and `max_volume_m3` against container requirements
- **Tariff Range Matching**: Use volume/weight ranges in `Tariff` table to determine applicable pricing
- **Segment State Management**: Each route segment has independent status tracking (`ESTIMADO → ASIGNADO → INICIADO → FINALIZADO`)

### Data Design Patterns
- **Audit Trail**: All entities have `created_at`/`updated_at` timestamps
- **Geographic Data**: Store coordinates as `DECIMAL(10,7)` for precision (see `Depot`, `Segment` tables)
- **Cost Tracking**: Dual cost tracking - estimated vs actual (`estimated_cost` vs `final_cost`)
- **Unique Business Identifiers**: Use business keys like `request_number`, `container.code`, `truck.plate`

## External Integrations

### Google Maps API Integration
- **Route Service Dependency**: `ruta-service` calls Google Maps Directions API for distance/duration
- **Cost Calculation**: Combine Maps API data with fuel consumption (`fuel_consumption_l_per_km`) and tariff rates
- **Geolocation**: Use depot coordinates and client addresses for routing calculations

### Authentication Flow
- **JWT Tokens**: All API calls through gateway require valid JWT from Keycloak
- **Role-Based Access**: Three distinct user types with different permissions
  - `cliente`: Submit requests, track containers
  - `operador`: Manage catalogs, assign trucks
  - `transportista`: Update segment status, record actual times/costs

## Development Workflow

### Database Schema Evolution
- **Source of Truth**: `DER.puml` contains the canonical data model
- **Migration Strategy**: Each microservice manages its own MySQL database
- **Cross-Service Queries**: Use service APIs, avoid direct database access between services

### Service Development Order
1. **Foundation Services**: `cliente-service`, `camion-service`, `deposito-service`, `tarifa-service`
2. **Complex Logic**: `contenedor-service` (with tariff validation), `ruta-service` (routing engine)
3. **Orchestration**: `solicitud-service` (coordinates other services)
4. **Infrastructure**: Gateway and Keycloak integration

### Testing Approach
- **Integration Testing**: Test service-to-service communication patterns
- **Route Calculation Testing**: Mock Google Maps API responses for consistent testing
- **State Transition Testing**: Verify request/segment status workflows
- **Capacity Validation Testing**: Test truck assignment logic with various container sizes

## Critical Business Logic

### Route Optimization Logic
- **Multi-Depot Routing**: Routes can chain through multiple depots for cost optimization
- **Truck Assignment**: Filter trucks by capacity before assigning to segments
- **Cost Estimation**: Factor in distance, fuel consumption, depot storage costs, and time

### Status Management
- **Request Status**: Must align with container status throughout lifecycle
- **Segment Independence**: Each route segment can be managed by different trucks and tracked separately
- **Time Tracking**: Record both estimated and actual times for performance analysis

### Error Handling Patterns
- **Capacity Violations**: Reject requests when no available truck can handle container size
- **Routing Failures**: Graceful degradation when Maps API is unavailable
- **Authentication Failures**: Ensure proper error responses maintain security context