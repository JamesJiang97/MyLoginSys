<template>

    <div class="drop">
        <div class="glass"></div>
    </div>

</template>

<style>
.glass {
    height: 100%;
    width: 100%;
    filter: blur(2px);
    background-color: rgba(0, 0, 0, 0.871);
    opacity: 40%;
}

.drop {
    width: 240px;
    height: 280px;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    margin: auto;
    padding: 50px 40px 40px 40px;
    filter: drop- shadow(0px 20px 10px rgba(0, 0, 0, 0.5));
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>

