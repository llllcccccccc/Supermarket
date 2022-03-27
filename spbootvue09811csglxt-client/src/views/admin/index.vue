<template>
    <div class="altair-index" :class="{'aside-close':!asideStatus}">
        <altair-aside></altair-aside>
        <div class="altair-main">
            <altair-header @switch-aside="switchAside" :aside-status="asideStatus"></altair-header>
            <div class="altair-content">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>
<style type="text/scss" lang="scss">
    .altair-index {
        height: 100%;
        display: flex;
        background: #ececec;
        .altair-aside {
            flex-grow: 0;
            flex-shrink: 0;
            width: 240px;
            max-width: 240px;
            border-right: 1px solid rgba(0, 0, 0, 0.12);
            height: 100%;

            background: #fff;
            transition: all 280ms cubic-bezier(0.4, 0, 0.2, 1);
        }
        &.aside-close {
            .altair-aside {
                max-width: 0;
            }
        }

        .altair-main {
            flex-grow: 1;
            display: flex;
            flex-flow: column;
        }
        .altair-header {
            flex-grow: 0;
            flex-shrink: 0;
            background: #1976d2;
            box-shadow: 3px 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
            padding: 0 25px;
            height: 48px;
            line-height: 48px;
            border-left: 1px solid #ffffff;
        }
        .altair-content {
            padding: 20px;
            overflow: hidden auto;
            .iframe {
                background: #ffffff;
                width: 100%;
                border: none;
                height: calc(100vh - 48px - 48px);
                overflow: hidden auto;
            }
        }
    }
</style>
<script>
    import AltairAside from "./aside";
    import AltairHeader from "./header";
    export default {
        name: "altair-index",
        components: { AltairHeader, AltairAside },
        data() {
            return {
                asideStatus: true,
            };
        },
        watch: {},
        computed: {},
        methods: {
            switchAside() {
                this.asideStatus = !this.asideStatus;
            },
        },
        created() {},
        mounted() {},
        destroyed() {},
    };
</script>
