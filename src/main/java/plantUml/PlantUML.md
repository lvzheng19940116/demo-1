@startuml 
object Test1 
object Test2 
@enduml


@startuml 
[*] --> Test 
state "Test" as Test { 
 state "Testing Module" as TM 
 state "Configuring Module" as CM 
 [*] --> CM 
 TM --> CM : Testing1 
 CM --> TM : Testing2 
} 
note right of Test : 状态图实例
@enduml


 @startuml 
 title Lotus 
 interface "IBMDocs" as SC 
 package "Test1" { 
 SC - [ 第一个组件 ] 
 Notes - [ 第一个组件 ]: use 
 Symphony - [ 第二个组件 ] 
 [ 其他组件 ] 
 } 
 package "Test2" { 
 Connections - [ 第三个组件 ] 
 [ 第一个组件 ] --> iNotes 
 } 
 @enduml 
 
 
 
@startuml
HttpRequest -> OrdermainsController:OrdermainsForm
OrdermainsController->OrdermainsService: ordermainsSplit( OrdermainsForm ordermainsForm)
OrdermainsService->OrdermainsServiceImpl:ordermainsSplit(OrdermainsForm ordermainsForm)
OrdermainsServiceImpl->OrdermainsServiceImpl:ordermainsSplit(OrdermainsForm ordermainsForm)
OrdermainsServiceImpl->OrdermainsServiceImpl:splitBySource(ordergoodsFormList, sourceFlag)
OrdermainsServiceImpl->OrdermainsServiceImpl:splitOrdergoods()
OrdermainsServiceImpl->OrdermainsServiceImpl:ordermainSplitByMtart(ordergoodsFormList)
OrdermainsServiceImpl->SystemdictionariesRepository:findByCategory(category)
SystemdictionariesRepository->OrdermainsServiceImpl:findByCategory(category)
OrdermainsServiceImpl->GoodsmaterialsRepository:findByLenovomaterialnumber(mtmcode)
GoodsmaterialsRepository->OrdermainsServiceImpl:findByLenovomaterialnumber(mtmcode)
OrdermainsServiceImpl->OrdermainsServiceImpl:ordermainSplitByProductgroups()
OrdermainsServiceImpl->productgroupsRepository:findAll()
productgroupsRepository->OrdermainsServiceImpl:findAll()
OrdermainsServiceImpl->OrdermainsServiceImpl:ordermainSplitByOrderreason()
OrdermainsServiceImpl->OrdermainsServiceImpl:createPono(ordergoodsFormList)
OrdermainsServiceImpl->OrdermainsServiceImpl:sumTotalPrice(mapByPono)
OrdermainsServiceImpl->OrdermainsServiceImpl:createOrdermainsonsDto(ordermains, sumTotalPriceMap, mapByPono)
OrdermainsServiceImpl->ProvincesRepository:findByProvinceno(ordermains.getSellerprovince())
ProvincesRepository->OrdermainsServiceImpl:findByProvinceno(ordermains.getSellerprovince())
OrdermainsServiceImpl->OrdermainsService:ordermainsSplit(OrdermainsForm ordermainsForm)
OrdermainsService->OrdermainsController:ordermainsSplit( OrdermainsForm ordermainsForm)
OrdermainsController->HttpResponse:ResultVO
@enduml




@startuml
title Android Broadcast procedure
'author Ali.Xulun
'version 1.0.0
participant Activity #Lime
participant ContextWrapper #Cyan
participant ContextImpl #Cyan
participant ActivityManagerService #Cyan
participant ActivityStackSupervisor #Cyan
participant ActivityStack #Cyan
participant ApplicationThreadProxy #Silver
participant InnerReceiver #Magenta
participant ReceiverDispatcher #Magenta
participant BroadcastReceiver #Magenta

autonumber
Activity -> ContextWrapper : registerReceiver()
ContextWrapper -> ContextImpl : registerReceiver()
ContextImpl -> LoadedApk : getReceiverDispatcher()
LoadedApk -> ActivityManagerProxy : registerReceiver()
ActivityManagerProxy -> ActivityManagerService : registerReceiver()

Activity -> ContextWrapper : sendBroadcast()
ContextWrapper -> ContextImpl : sendBroadcast()
ContextImpl -> ActivityManagerService: broadcastIntent()
ActivityManagerService -> ActivityManagerService : broadcastIntentLocked()
ActivityManagerService -> ActivityManagerService : collectReceiverComponents()
ActivityManagerService -> ActivityManagerService : scheduleBroadcastsLocked()
ActivityManagerService -> ActivityManagerService : processNextBroadcast()
ActivityManagerService -> ActivityManagerService : deliverToRegisteredReceiverLocked()
ActivityManagerService -> ActivityManagerService : performReceiveLocked()
ActivityManagerService -> ApplicationThreadProxy : scheduleRegisteredReceiver()
ApplicationThreadProxy -> InnerReceiver : performReceive()
InnerReceiver -> ReceiverDispatcher : performReceive()
ReceiverDispatcher -> BroadcastReceiver : onReceive()

Activity -> ContextWrapper : sendOrderedBroadcast()
ContextWrapper -> ContextImpl : sendOrderedBroadcast()
ContextImpl -> ActivityManagerService: broadcastIntent()
@enduml