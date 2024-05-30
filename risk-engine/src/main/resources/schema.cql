CREATE KEYSPACE IF NOT EXISTS peer_payments  WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

CREATE TABLE IF NOT EXISTS peer_payments.payment_processing (
    transaction_id UUID,         // Partition key (unique identifier for the payment)
    updated_time BIGINT,  // Clustering key (for ordering status)
    status TEXT,          // The payment status at this point in time
    metadata TEXT,          // Any other relevant details for this status update
    PRIMARY KEY (transaction_id, updated_time)
) WITH CLUSTERING ORDER BY (updated_time DESC);