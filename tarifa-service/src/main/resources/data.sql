-- Tarifa nacional básica: traslado de contenedor 20 pies
INSERT INTO tariff (
    name, base_cost_per_km, volume_range_min, volume_range_max,
    weight_range_min, weight_range_max, storage_cost_per_day,
    fuel_price_per_liter, fixed_price_per_section, created_at
) VALUES (
    'Tarifa Nacional',
    1500.00, 0.000, 33.000,     -- volumen en m³
    0.00, 24000.00,            -- peso en kg
    2500.00, 1500, 5000.00,
    CURRENT_TIMESTAMP - INTERVAL '20 days'
);

-- Tarifa nacional premium: traslado de contenedor 40 pies
INSERT INTO tariff (
    name, base_cost_per_km, volume_range_min, volume_range_max,
    weight_range_min, weight_range_max, storage_cost_per_day,
    fuel_price_per_liter, fixed_price_per_section, created_at
) VALUES (
    'Tarifa Nacional',
    2000.00, 33.000, 67.000,
    0.00, 30000.00,
    3500.00, 1500, 7000.00,
    CURRENT_TIMESTAMP - INTERVAL '10 days'
);

-- Tarifa internacional: traslado de contenedor 40 pies con cruce fronterizo
INSERT INTO tariff (
    name, base_cost_per_km, volume_range_min, volume_range_max,
    weight_range_min, weight_range_max, storage_cost_per_day,
    fuel_price_per_liter, fixed_price_per_section, created_at
) VALUES (
    'Tarifa Internacional',
    2500.00, 33.000, 67.000,
    1000.00, 30000.00,
    5000.00, 1800, 10000.00,
    CURRENT_TIMESTAMP - INTERVAL '5 days'
);

-- Tarifa express: traslado urgente de contenedor 20 pies
INSERT INTO tariff (
    name, base_cost_per_km, volume_range_min, volume_range_max,
    weight_range_min, weight_range_max, storage_cost_per_day,
    fuel_price_per_liter, fixed_price_per_section, created_at
) VALUES (
    'Tarifa Express',
    2200.00, 0.000, 33.000,
    0.00, 24000.00,
    4000.00, 1700, 8000.00,
    CURRENT_TIMESTAMP - INTERVAL '2 days'
);

-- Tarifa económica: traslado de contenedor ligero (half-height o vacío)
INSERT INTO tariff (
    name, base_cost_per_km, volume_range_min, volume_range_max,
    weight_range_min, weight_range_max, storage_cost_per_day,
    fuel_price_per_liter, fixed_price_per_section, created_at
) VALUES (
    'Tarifa Económica',
    1000.00, 0.000, 20.000,
    0.00, 5000.00,
    1500.00, 1400, 3000.00,
    CURRENT_TIMESTAMP
);