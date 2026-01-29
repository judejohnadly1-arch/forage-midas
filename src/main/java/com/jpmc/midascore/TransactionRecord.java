package com.jpmc.midascore;
import com.jpmc.midascore.entity.UserRecord;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class TransactionRecord
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private UserRecord sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id", nullable = false)
    private UserRecord recipient;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    protected TransactionRecord() {
    }

    public TransactionRecord(UserRecord sender, UserRecord recipient, float amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    // Getters only (no setters needed after creation)
    public Long getId()           { return id; }
    public UserRecord getSender()   { return sender; }
    public UserRecord getRecipient(){ return recipient; }
    public float getAmount()       { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
