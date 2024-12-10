CREATE TABLE IF NOT EXISTS `customer` (
    `customer_id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `mobile_number` varchar(20) NOT NULL,
    `created_at` datetime NOT NULL,
    `created_by` varchar(255) NOT NULL,
    `updated_at` datetime NULL,
    `updated_by` varchar(255) NULL,
    PRIMARY KEY (`customer_id`)
);