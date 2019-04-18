package org.code4everything.efo.stand.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.code4everything.boot.bean.BaseBean;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author pantao
 * @since 2019-04-17
 */
@Data
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "efo_file", indexes = {@Index(name = "access_url_index", columnList = "accessUrl", unique = true),
        @Index(name = "user_id_index", columnList = "userId")})
public class FileDO implements BaseBean, Serializable {

    private static final long serialVersionUID = 5947621674068025981L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(columnDefinition = "varchar(32)", nullable = false)
    private String filename;

    @Column(columnDefinition = "varchar(256)", nullable = false, unique = true)
    private String localPath;

    @Column(columnDefinition = "varchar(128)", nullable = false)
    private String accessUrl;

    @Column(nullable = false)
    private Long size;

    @Column(columnDefinition = "varchar(32) comment '使用 `/` 做为标签分隔符'")
    private String tag;

    @Column(nullable = false)
    private Long userId;

    @Column(columnDefinition = "varchar(64)")
    private String description;

    private Integer categoryId;

    @Column(columnDefinition = "char(1) default '1' comment '状态：0不能被访问，1允许访问但不列出，2允许访问并列出'")
    private Character status;

    @Column(columnDefinition = "datetime default current_timestamp", nullable = false)
    private LocalDateTime createTime;
}
