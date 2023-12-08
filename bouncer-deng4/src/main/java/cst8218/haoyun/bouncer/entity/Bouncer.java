/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.haoyun.bouncer.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Haoyun Deng
 * 
 * This is the class that defines the Bouncer entity. It contains the fields and methods required to implement Bouncer correctly in your application.
 * The @Entity annotation specifies that the entity should be represented as a table in the database using smae names as classes. 
 * @XmlRootElement annotation specifies that this class can be converted to and from XML during serialization.
 */
@Entity
@XmlRootElement
public class Bouncer implements Serializable {

    //Width of x-axis in game
    public static final int F_WIDTH = 600;

    //Width of y-axis in game
    public static final int F_HEIGHT = 600;

    // Gravity acceleration
    public static final int GRAVITY_ACCEL = 1;

    //Speed decay rate for each bounce
    public static final int DECAY_RATE = 1;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer xPosition = 0;

    private Integer yPosition = 0;

    private Integer yVelocity = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getXPosition() {
        return xPosition;
    }

    public void setXPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    public Integer getYPosition() {
        return yPosition;
    }

    public void setYPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }

    public Integer getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(Integer yVelocity) {
        this.yVelocity = yVelocity;
    }

    /**
     * Updates the properties to simulate the passing of one unit of time.
     * Update the y-axis coordinate and speed, and realize bouncing to change the direction of movement
     */
    public void advanceOneFrame() {

        this.yPosition += this.yVelocity;

        if (this.yPosition < 0) {
            this.yPosition = 0;
        } else if (this.yPosition > F_HEIGHT) {
            this.yPosition = F_HEIGHT;
        }

        if (yPosition < F_HEIGHT) {
            yVelocity = yVelocity + GRAVITY_ACCEL;
        }

        //if we've bounced, reverse the direction and apply decay
        if (yPosition <= 0 || yPosition >= F_HEIGHT) {
            yVelocity = -yVelocity;
            if (yVelocity < 0) {
                yVelocity = yVelocity + DECAY_RATE;
            } else if (yVelocity > 0) {
                yVelocity = yVelocity - DECAY_RATE;
            }
        }

    }

    /**
     *This method updates the Bouncer's value. For every non-null property of the new bodyguard, the old bodyguard is updated for that given property.
     */
    public void updates(Bouncer bouncer) {

        if (this.getYPosition() != null) {
            bouncer.setYPosition(this.getYPosition());
        }

        if (this.getXPosition() != null) {
            bouncer.setXPosition(this.getXPosition());
        }

        if (this.getYVelocity() != null) {
            bouncer.setYVelocity(this.getYVelocity());
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bouncer)) {
            return false;
        }
        Bouncer other = (Bouncer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cst8218.haoyun.bouncer.entity.Bouncer[ id=" + id + " ]";
    }

}
