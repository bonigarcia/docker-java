package com.github.dockerjava.core.command;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Filters;

/**
 * List containers
 *
 * @param showAll
 *            - true or false, Show all containers. Only running containers are shown by default.
 * @param showSize
 *            - true or false, Show the containers sizes. This is false by default.
 * @param limit
 *            - Show `limit` last created containers, include non-running ones. There is no limit by default.
 * @param sinceId
 *            - Show only containers created since Id, include non-running ones.
 * @param beforeId
 *            - Show only containers created before Id, include non-running ones.
 *
 */
public class ListContainersCmdImpl extends AbstrDockerCmd<ListContainersCmd, List<Container>> implements
        ListContainersCmd {

    private Integer limit = -1;

    private Boolean showSize, showAll = false;

    private String sinceId, beforeId;

    private Filters filters;

    public ListContainersCmdImpl(ListContainersCmd.Exec exec) {
        super(exec);
    }

    @Override
    public Integer getLimit() {
        return limit;
    }

    @Override
    public Boolean hasShowSizeEnabled() {
        return showSize;
    }

    @Override
    public Boolean hasShowAllEnabled() {
        return showAll;
    }

    @Override
    public String getSinceId() {
        return sinceId;
    }

    @Override
    public String getBeforeId() {
        return beforeId;
    }

    @Override
    public Filters getFilters() {
        return filters;
    }

    @Override
    public ListContainersCmd withShowAll(Boolean showAll) {
        this.showAll = showAll;
        return this;
    }

    @Override
    public ListContainersCmd withShowSize(Boolean showSize) {
        this.showSize = showSize;
        return this;
    }

    @Override
    public ListContainersCmd withLimit(Integer limit) {
        checkNotNull(limit, "limit was not specified");
        checkArgument(limit > 0, "limit must be greater 0");
        this.limit = limit;
        return this;
    }

    @Override
    public ListContainersCmd withSince(String since) {
        checkNotNull(since, "since was not specified");
        this.sinceId = since;
        return this;
    }

    @Override
    public ListContainersCmd withBefore(String before) {
        checkNotNull(before, "before was not specified");
        this.beforeId = before;
        return this;
    }

    @Override
    public ListContainersCmd withFilters(Filters filters) {
        checkNotNull(filters, "filters was not specified");
        this.filters = filters;
        return this;
    }

}
